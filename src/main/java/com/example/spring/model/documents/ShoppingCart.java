package com.example.spring.model.documents;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.Data
@Document(collection = "Cart")
public class ShoppingCart {

  @Id
  String id;

  @lombok.NonNull
  List<Product> products;

  @lombok.NonNull
  String customer;

  int amount;
}
