package com.example.spring.model.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.spring.model.enums.StateProduct;

import jakarta.validation.constraints.Null;

@lombok.Setter
@lombok.Getter
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.ToString
@lombok.Builder
@Document("Product")
public class Product {

  @Id
  String id;

  @lombok.NonNull
  String nameSupplier;

  @lombok.NonNull
  String nameProduct;

  double priceProduct;

  int amountProduct;

  int amountMinProduct;

  @lombok.NonNull
  StateProduct stateProduct;

  @Null
  String image;

  int amountForProduct;

}
