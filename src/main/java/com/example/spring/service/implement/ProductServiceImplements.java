package com.example.spring.service.implement;

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

  @Override
  public Product updateProducts(UpdateProduct updateProduct) throws ProductException {
    Optional<Product> product = productRepository.findById(updateProduct.id());
    if (product.isEmpty())
      throw new RuntimeException("User not found");
    Product aux = product.get();
    aux.setAmountMinProduct(updateProduct.amountMinProduct());
    aux.setImages(updateProduct.images());
    aux.setNameProduct(updateProduct.nameProduct());
    aux.setPriceProduct(updateProduct.priceProduct());
    aux.setAmountProduct(updateProduct.amountProduct());
    aux.setId(updateProduct.id());
    productRepository.save(aux);
    return aux;

  }

  @Override
  public String deleteProduct(String id) throws ProductException {
    productRepository.deleteById(id);
    return "succesfully delete product";
  }
}
