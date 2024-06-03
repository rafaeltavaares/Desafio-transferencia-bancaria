package com.example.picpay.services;

import com.example.picpay.DTOs.TransactionDTO;
import com.example.picpay.domain.transaction.Transaction;
import com.example.picpay.domain.user.User;
import com.example.picpay.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class TransactionService {

    @Autowired
    private UserService user_service;

    @Autowired
    private TransactionRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private NotificationService notificationService;

    public Transaction createTransaction(TransactionDTO data) throws Exception {
        User sender = user_service.findUserById(data.sender_id());
        User receiver = user_service.findUserById(data.receiver_id());

        user_service.validateTransaction(sender,data.amount());

        boolean isAthorized = this.authorizeTransaction(sender,data.amount());
        if(!isAthorized){
            throw new RuntimeException("Transação nao autorizada");
        }

        Transaction newtransaction = new Transaction();
        newtransaction.setAmount(data.amount());
        newtransaction.setSender(sender);
        newtransaction.setReceiver(receiver);
        newtransaction.setTimestamp(LocalDateTime.now());

        sender.setBalance(sender.getBalance().subtract(data.amount()));
        receiver.setBalance(receiver.getBalance().add(data.amount()));

        repository.save(newtransaction);
        user_service.saveUser(sender);
        user_service.saveUser(receiver);

//        this.notificationService.sendNotification(sender,"Transacao realizar com sucesso");
//        this.notificationService.sendNotification(receiver,"Transcao realizada com sucesso");

        return newtransaction;

    }
    public boolean authorizeTransaction(User sender, BigDecimal amount){
      ResponseEntity<Map> authorizationResponse  = restTemplate.getForEntity("https://util.devi.tools/api/v2/authorize", Map.class);
      if(authorizationResponse.getStatusCode() == HttpStatus.OK) {
          var message = authorizationResponse.getBody().get("status");
          return "success".equalsIgnoreCase((String) message);
      }else return false;

    }

    public List<Transaction> findTransaction(Long id) throws Exception {
        return this.repository.findTransactionBySender_id(id);
    }

}
