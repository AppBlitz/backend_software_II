package com.example.spring.service.implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.dto.product.ProductsDto;
import com.example.spring.dto.product.UpdateProduct;
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
    if (productRepository.existsByNameProduct(productDto.nameProduct()))
      throw new RuntimeException("exists product");
    Product product = productRepository.save(dtoAobject(productDto));
    return product;
  }

  @Override
  public Product dtoAobject(ProductsDto productdto) {
    Product product = Product.builder()
        .nameProduct(productdto.nameProduct())
        .nameSupplier(productdto.nameSupplier())
        .amountMinProduct(productdto.amountMinProduct())
        .stateProduct(productdto.stateProduct())
        .priceProduct(productdto.priceProduct())
        .image(productdto.image())
        .build();
    return product;
  }

  @Override
  public Optional<Product> findById(String id) throws ProductException {
    return productRepository.findById(id);
  }

  @Override
  public Product updateProducts(UpdateProduct updateProduct) throws ProductException {
    Optional<Product> product = productRepository.findById(updateProduct.id());
    if (product.isEmpty())
      throw new RuntimeException("User not found");
    Product aux = Product.builder()
        .amountMinProduct(updateProduct.amountMinProduct())
        .nameProduct(updateProduct.nameProduct())
        .priceProduct(updateProduct.priceProduct())
        .image(updateProduct.image())
        .amountProduct(updateProduct.amountProduct())
        .stateProduct(updateProduct.stateProduct())
        .nameSupplier(updateProduct.nameSupplier())
        .build();
    productRepository.save(aux);
    return aux;

  }

  @Override
  public String deleteProduct(String id) throws ProductException {
    productRepository.deleteById(id);
    return "succesfully delete product";
  }

  @Override
  public List<Product> findAll() throws ProductException {
    List<Product> products = productRepository.findAll();
    return products;
  }

}
