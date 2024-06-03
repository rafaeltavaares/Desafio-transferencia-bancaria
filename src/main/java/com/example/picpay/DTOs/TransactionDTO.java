package com.example.picpay.DTOs;

import java.math.BigDecimal;

public record TransactionDTO(BigDecimal amount, Long sender_id, Long receiver_id) {


}
