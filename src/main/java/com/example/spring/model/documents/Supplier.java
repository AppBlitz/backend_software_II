package com.example.spring.model.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Document(collection = "Supplier")
public class Supplier {

  @Id
  String id;

  @NonNull
  String nameSupplier;

  @NonNull
  String identificationNumber;

  @NonNull
  String phoneNumber;

}
