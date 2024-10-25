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
    Optional<Product> productOptional = productRepository.findById(updateProduct.id());

    if (productOptional.isEmpty()) {
      throw new RuntimeException("Product not found");
    }

    Product product = productOptional.get();
    product.setAmountMinProduct(updateProduct.amountMinProduct());
    product.setNameProduct(updateProduct.nameProduct());
    product.setPriceProduct(updateProduct.priceProduct());
    product.setImage(updateProduct.image());
    product.setAmountProduct(updateProduct.amountProduct());
    product.setStateProduct(updateProduct.stateProduct());
    product.setNameSupplier(updateProduct.nameSupplier());

    productRepository.save(product);

    return product;
  }

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
