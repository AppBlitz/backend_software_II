package com.example.spring.dto.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.NonNull;

public record CustomerDto(@NonNull @Size(max=40)String nameCustomer,
@NonNull @Email String email,
                                @NonNull @Size(max = 30) @Size(min = 8) String password,
@NonNull
@Size(max = 11)
@Size(min = 7)
String numberIdentification,
@NonNull
@Size(max = 10)
@Size(min = 10)
String numberPhone,
@NonNull
String image)
{

}
