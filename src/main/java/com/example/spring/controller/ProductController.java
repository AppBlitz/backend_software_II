package com.example.spring.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.spring.dto.product.ProductsDto;
import com.example.spring.model.documents.Product;

public interface ProductController {

  public ResponseEntity<?> addProducts(@RequestBody ProductsDto productsdto) throws Exception;

  public Optional<Product> findById(String id) throws Exception;
}
