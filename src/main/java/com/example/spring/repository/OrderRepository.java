package com.example.spring.repository;

import com.example.spring.model.documents.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {



}
