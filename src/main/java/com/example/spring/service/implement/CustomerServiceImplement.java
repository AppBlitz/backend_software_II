package com.example.spring.service.implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.dto.customer.CustomerDto;
import com.example.spring.dto.customer.UpdateCustomerDto;
import com.example.spring.exceptions.CustomerException;
import com.example.spring.exceptions.CustomerExceptionId;
import com.example.spring.model.documents.Customer;
import com.example.spring.repository.CustomerRepository;
import com.example.spring.service.CustomerService;

@Service
public class CustomerServiceImplement implements CustomerService {

  @Autowired
  CustomerRepository customerRepository;

  @Override
  public Optional<Customer> searchCustomer(String id) throws CustomerExceptionId {
    return customerRepository.findById(id);
  }

  @Override
  public Customer saveCustomer(CustomerDto customerdto) throws CustomerException {
    Customer customer = dtoAobject((customerdto));
    return customerRepository.save(customer);
  }

  public Customer dtoAobject(CustomerDto customerdto) {
    Customer customer = new Customer();
    customer.setNameCustomer(customerdto.nameCustomer());
    customer.setPhoneNumber(customerdto.numberPhone());
    customer.setPassword(customerdto.password());
    customer.setImage(customerdto.image());
    customer.setEmail(customerdto.email());
    customer.setNumberIdentification(customerdto.numberIdentification());
    return customer;
  }

  public String deleteCustomer(String id) {
    customerRepository.deleteById(id);
    return "succesfully deleted Customer";
  }

  public List<Customer> findAllCustomer() {
    return customerRepository.findAll();
  }

  @Override
  public Customer updateCustomer(UpdateCustomerDto updateCustomerDto) throws CustomerException {
    Optional<Customer> customer = customerRepository
        .findByNumberIdentification(updateCustomerDto.numberIdentification());
    Customer auxCustomer = customer.get();
    auxCustomer.setNameCustomer(updateCustomerDto.nameCustomer());
    auxCustomer.setNumberIdentification(updateCustomerDto.numberIdentification());
    auxCustomer.setPassword(updateCustomerDto.password());
    auxCustomer.setEmail(updateCustomerDto.email());
    auxCustomer.setPhoneNumber(updateCustomerDto.phoneNumber());
    auxCustomer.setImage(updateCustomerDto.image());
    customerRepository.save(auxCustomer);
    return auxCustomer;
  }
}
