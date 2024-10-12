
package com.example.spring.service;

import java.util.List;
import java.util.Optional;

import com.example.spring.dto.product.ProductsDto;
import com.example.spring.dto.product.UpdateProduct;
import com.example.spring.exceptions.ProductException;
import com.example.spring.model.documents.Product;

public interface ProductService {

  public Product saveProduct(ProductsDto productDto) throws ProductException;

  public Product dtoAobject(ProductsDto productdto);

  public Optional<Product> findById(String id) throws ProductException;

  public Product updateProducts(UpdateProduct updateProduct) throws ProductException;

  public String deleteProduct(String id) throws ProductException;

  public List<Product> findAll() throws ProductException;

}
