package com.example.spring.service.implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.dto.customer.CustomerDto;
import com.example.spring.dto.customer.LoginCustomerDto;
import com.example.spring.dto.customer.UpdateCustomerDto;
import com.example.spring.exceptions.CustomerException;
import com.example.spring.exceptions.CustomerExceptionEmail;
import com.example.spring.exceptions.CustomerExceptionId;
import com.example.spring.exceptions.CustomerExceptionPassword;
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
    if (customerRepository.existsByNumberIdentification(customerdto.numberIdentification()))
      throw new RuntimeException("User exists");
    Customer customer = dtoAobject(customerdto);
    return customerRepository.save(customer);
  }

  public Customer dtoAobject(CustomerDto customerdto) {
    Customer customer = Customer.builder()
        .numberIdentification(customerdto.numberIdentification())
        .phoneNumber(customerdto.numberPhone())
        .password(customerdto.password())
        .image(customerdto.image())
        .email(customerdto.email())
        .nameCustomer((customerdto.nameCustomer()))
        .build();
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
        .findById(updateCustomerDto.idCustomer());
    if (customer.isEmpty())
      throw new CustomerException("Customer not");
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

  @Override
  public Optional<Customer> login(LoginCustomerDto loginCustomerDto)
      throws CustomerExceptionPassword, CustomerExceptionEmail {
    return customerRepository.findByEmailAndPassword(loginCustomerDto.email(), loginCustomerDto.password());
  }
}
