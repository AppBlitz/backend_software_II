package com.example.spring.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.spring.model.documents.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {

  Optional<Customer> findById(String id);

  Optional<Customer> findByNumberIdentification(String identificationNumber);

}
