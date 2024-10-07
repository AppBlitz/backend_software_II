package com.example.spring.model.documents;

import org.springframework.data.annotation.Id;

@lombok.Data
@lombok.AllArgsConstructor
@lombok.ToString
@lombok.NoArgsConstructor
public class Detail {

  @Id
  String id;

  @lombok.NonNull
  Product product;

  int amount;

}
