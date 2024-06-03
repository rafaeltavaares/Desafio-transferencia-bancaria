package com.example.picpay.DTOs;

import com.example.picpay.domain.user.UserType;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record UserDTO(@NotBlank String firstName, String lastName, String document, String password, BigDecimal balance, String email, UserType userType) {
}
