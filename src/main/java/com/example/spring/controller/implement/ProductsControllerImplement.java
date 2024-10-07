package com.example.spring.controller.implement;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.controller.ProductController;
import com.example.spring.dto.product.ProductsDto;
import com.example.spring.dto.product.UpdateProduct;
import com.example.spring.model.documents.Product;
import com.example.spring.service.implement.ProductServiceImplements;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductsControllerImplement implements ProductController {

  @Autowired
  ProductServiceImplements productService;

  @Override
  @RequestMapping(value = "/add/product", method = RequestMethod.POST)
  public ResponseEntity<?> addProducts(@RequestBody() ProductsDto productsdto) throws Exception {
    return ResponseEntity.status(200).body(productService.saveProduct(productsdto));
  }

  @Override
  @RequestMapping(value = "/search/{id}", method = RequestMethod.GET)
  public Optional<Product> findById(@PathVariable("id") String id) throws Exception {
    return productService.findById(id);
  }

  @Override
  @RequestMapping(value = "/product/update", method = RequestMethod.PUT)
  public ResponseEntity<Product> updateProduct(@RequestBody() UpdateProduct updateProduct) throws Exception {
    Product product = productService.updateProducts(updateProduct);
    return ResponseEntity.status(200).body(product);
  }

  @Override
  @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<String> deleteProduct(@PathVariable("id") String id) throws Exception {
    return ResponseEntity.status(200).body(productService.deleteProduct(id));
  }

}
