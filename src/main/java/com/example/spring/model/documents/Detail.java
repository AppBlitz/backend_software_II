package com.example.spring.model.documents;

import org.springframework.data.annotation.Id;
import lombok.*;

@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Builder

public class Detail {

  @lombok.NonNull
  Product product;

  int cant;

  int amount;

}
