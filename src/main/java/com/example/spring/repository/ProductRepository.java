package com.example.spring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.spring.model.documents.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

  Optional<Product> findById(String id);

  @Query("{'nameProduct':?0}")
  List<?> findByName(String nameProduct);
}
