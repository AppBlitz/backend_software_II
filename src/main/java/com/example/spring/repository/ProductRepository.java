package com.example.spring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.spring.model.documents.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

  @Query("{'nameProduct': :#{#nameProduct}}")
  List<Product> findByName(@Param("nameProduct") String nameProduct);

  @Query("{'id': :#{#id}}")
  Optional<Product> findById(@Param("id") String id);

  @Query("{'id' : :#{#id}, 'nameProduct' : :#{#nameProduct}}")
  List<Product> findByProducts(@Param("id") String id, @Param("nameProduct") String nameProduct);

  @Query("{'activate': true}")
  List<Product> findAllProduct();

  @Query("{'nameSupplier': :#{#nameSupplier}}")
  Optional<Product> searchProductSupplier(@Param("nameSupplier") String nameSupplier);

  boolean existsByNameProduct(String nameProduct);

}
