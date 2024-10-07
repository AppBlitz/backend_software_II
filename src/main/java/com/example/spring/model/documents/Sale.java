package com.example.spring.model.documents;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

@lombok.Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.ToString
public class Sale {

  @Id
  String id;

  @lombok.NonNull
  LocalDateTime date;

  double total;

  @lombok.NonNull
  Customer customer;
}
