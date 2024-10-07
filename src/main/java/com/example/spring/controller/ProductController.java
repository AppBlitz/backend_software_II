package com.example.spring.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.spring.dto.product.ProductsDto;
import com.example.spring.dto.product.UpdateProduct;
import com.example.spring.model.documents.Product;

public interface ProductController {

  public ResponseEntity<?> addProducts(@RequestBody ProductsDto productsdto) throws Exception;

  public Optional<Product> findById(String id) throws Exception;

  public ResponseEntity<Product> updateProduct(@RequestBody UpdateProduct updateProductDto) throws Exception;

  public ResponseEntity<String> deleteProduct(@PathVariable String id) throws Exception;
}
