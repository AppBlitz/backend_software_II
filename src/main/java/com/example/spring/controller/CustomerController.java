package com.example.spring.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.spring.dto.customer.CustomerDto;
import com.example.spring.dto.customer.LoginCustomerDto;
import com.example.spring.dto.customer.UpdateCustomerDto;
import com.example.spring.model.documents.Customer;

public interface CustomerController {
  public ResponseEntity<Customer> loginCustomer(@RequestBody CustomerDto loginCustomerDto) throws Exception;

  public ResponseEntity<Optional<Customer>> searchCustomer(@PathVariable String id) throws Exception;

  public ResponseEntity<String> deleCustomer(@PathVariable String id) throws Exception;

  public ResponseEntity<Customer> updateCustomer(@RequestBody UpdateCustomerDto updateCustomer) throws Exception;

  public ResponseEntity<Optional<Customer>> login(@RequestBody LoginCustomerDto loginCustomerdto) throws Exception;
}
