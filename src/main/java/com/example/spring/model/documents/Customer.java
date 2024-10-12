package com.example.spring.model.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.NonNull;

@lombok.Setter
@lombok.Getter
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
@lombok.ToString
@lombok.Builder
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
