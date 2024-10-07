package com.example.spring.model.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.NonNull;
import lombok.ToString;

@lombok.Data
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
@ToString
@Document(collection = "Customer")
public class Customer {

  @Id
  String id;

  @NonNull
  String nameCustomer;

  @NonNull
  String password;

  @NonNull
  String phoneNumber;

  @NonNull
  String email;

  @NonNull
  String numberIdentification;

  @NonNull
  String image;

}
