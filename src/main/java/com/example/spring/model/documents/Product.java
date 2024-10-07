package com.example.spring.model.documents;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.spring.model.enums.StateProduct;

import jakarta.validation.constraints.Null;
import lombok.ToString;

@lombok.Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@ToString
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
  List<String> images;

  int amountForProduct;

}
