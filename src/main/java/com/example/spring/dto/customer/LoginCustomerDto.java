package com.example.spring.dto.customer;

public record LoginCustomerDto(@lombok.NonNull String email, @lombok.NonNull String password) {
}
