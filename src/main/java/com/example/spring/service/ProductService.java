
package com.example.spring.service;

import java.util.Optional;

import com.example.spring.dto.product.ProductsDto;
import com.example.spring.exceptions.ProductException;
import com.example.spring.model.documents.Product;

public interface ProductService {

  public Product saveProduct(ProductsDto productDto) throws ProductException;

  public Product dtoAobject(ProductsDto productdto);

  public Optional<Product> findById(String id) throws ProductException;

}
