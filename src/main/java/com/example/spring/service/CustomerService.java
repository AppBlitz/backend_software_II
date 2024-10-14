package com.example.spring.service;

import java.util.Optional;

import com.example.spring.dto.customer.CustomerDto;
import com.example.spring.dto.customer.LoginCustomerDto;
import com.example.spring.dto.customer.UpdateCustomerDto;
import com.example.spring.exceptions.CustomerException;
import com.example.spring.exceptions.CustomerExceptionEmail;
import com.example.spring.exceptions.CustomerExceptionId;
import com.example.spring.exceptions.CustomerExceptionPassword;
import com.example.spring.model.documents.Customer;

public interface CustomerService {

  public Optional<Customer> searchCustomer(String id) throws CustomerExceptionId;

  public Customer saveCustomer(CustomerDto customerdto) throws CustomerException;

  public Customer updateCustomer(UpdateCustomerDto updateCustomerDto) throws CustomerException;

  public Optional<Customer> login(LoginCustomerDto loginCustomerDto)
      throws CustomerExceptionPassword, CustomerExceptionEmail;
}
