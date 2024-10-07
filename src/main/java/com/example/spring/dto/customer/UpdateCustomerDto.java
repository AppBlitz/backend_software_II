package com.example.spring.dto.customer;

import jakarta.validation.constraints.Email;
import lombok.NonNull;

public record UpdateCustomerDto(@NonNull String nameCustomer, @NonNull String password, @NonNull String phoneNumber,
    @NonNull @Email String email, @NonNull String numberIdentification, @NonNull String image,
    @NonNull String idCustomer) {
}
