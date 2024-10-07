package com.example.spring.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.spring.model.documents.Supplier;

public interface SupplierRepository extends MongoRepository<Supplier, String> {

  @Query("{'id'}: :#{#id}")
  Optional<Supplier> findSupplier(@Param("id") String id);

  @Query("{'nameSupplier': :#{#nameSupplier}")
  Optional<Supplier> findnameSuplier(@Param("nameSupplier") String name);

  @Query("{'identificationNumber': :#{#identificationNumber}}")
  Optional<Supplier> findIdentificationNumber(@Param("identificationNumber") String identificationNumber);

}
