package com.example.spring.service.implement;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.dto.product.ProductsDto;
import com.example.spring.exceptions.ProductException;
import com.example.spring.model.documents.Product;
import com.example.spring.repository.ProductRepository;
import com.example.spring.service.ProductService;

@Service
public class ProductServiceImplements implements ProductService {

  @Autowired
  ProductRepository productRepository;

  @Override
  public Product saveProduct(ProductsDto productDto) throws ProductException {
    Product product = productRepository.save(dtoAobject(productDto));
    return product;
  }

  @Override
  public Product dtoAobject(ProductsDto productdto) {
    Product product = new Product();
    product.setAmountMinProduct(productdto.amountMinProduct());
    product.setPriceProduct(productdto.priceProduct());
    product.setStateProduct(productdto.stateProduct());
    product.setAmountProduct(productdto.amountProducts());
    product.setNameProduct(productdto.nameProduct());
    return product;
  }

  @Override
  public Optional<Product> findById(String id) throws ProductException {
    return productRepository.findById(id);
  }
}
