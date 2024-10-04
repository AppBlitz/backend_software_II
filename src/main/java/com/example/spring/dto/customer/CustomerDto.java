package com.example.spring.dto.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;
import lombok.NonNull;

public record CustomerDto(@NonNull @Max(20) @Size(max = 20) String nameCustomer, @NonNull @Email String email,
        @NonNull @Size(max = 30) @Size(min = 8) String password) {

}
