package com.example.spring.model.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.spring.model.enums.StateProduct;

@lombok.Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@Document("Product")
public class Product {

  @Id
  String id;

  @lombok.NonNull
  String nameProduct;

  double priceProduct;

  int amountProduct;

  int amountMinProduct;

  @lombok.NonNull
  StateProduct stateProduct;

}
