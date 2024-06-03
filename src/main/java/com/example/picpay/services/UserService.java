package com.example.picpay.services;

import com.example.picpay.DTOs.UserDTO;
import com.example.picpay.domain.user.User;
import com.example.picpay.domain.user.UserType;
import com.example.picpay.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public void validateTransaction(User sender, BigDecimal amount)throws Exception{
        if(sender.getUserType() == UserType.MERCHANT){
            throw new RuntimeException("Usuario do tipo lojista não está autorizado a realizar transação");
        }
            if(sender.getBalance().compareTo(amount) < 0){
            throw new RuntimeException("Saldo insuficiente");
        }
    }

    public User findUserById(Long id) throws Exception{
        return this.repository.findUserById(id).orElseThrow(() -> new RuntimeException("Usuario não encontrado."));
    }

    public void saveUser(User data){
        this.repository.save(data);
    }

    public User createUser(UserDTO data){

        User newUser = new User(data);
        this.saveUser(newUser);
        return newUser;
    }

    public List<User> getAllUsers(){
        return this.repository.findAll();
    }
}
