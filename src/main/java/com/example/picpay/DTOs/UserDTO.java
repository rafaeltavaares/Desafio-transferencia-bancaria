package com.example.picpay.DTOs;

import com.example.picpay.domain.user.UserType;

import java.math.BigDecimal;

public record UserDTO(String firstName, String lastName, String document, String password, BigDecimal balance, String email, UserType userType) {
}
