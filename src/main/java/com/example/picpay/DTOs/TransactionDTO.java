package com.example.picpay.DTOs;

import java.math.BigDecimal;

public record TransactionDTO(Long sender_id, Long receiver_id, BigDecimal amount) {


}
