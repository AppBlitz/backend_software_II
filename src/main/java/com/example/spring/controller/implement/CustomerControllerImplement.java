package com.example.spring.controller.implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.controller.CustomerController;
import com.example.spring.dto.customer.CustomerDto;
import com.example.spring.dto.customer.UpdateCustomerDto;
import com.example.spring.model.documents.Customer;
import com.example.spring.service.implement.CustomerServiceImplement;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/customers")
public class CustomerControllerImplement implements CustomerController {

  @Autowired
  CustomerServiceImplement customerService;

  @Override
  @RequestMapping(value = "/customer/create", method = RequestMethod.POST)
  public ResponseEntity<Customer> loginCustomer(@RequestBody() CustomerDto loginCustomerDto) throws Exception {
    Customer customer = customerService.saveCustomer((loginCustomerDto));
    return ResponseEntity.ok(customer);
  }

  @Override
  @RequestMapping(value = "/search/{id}")
  public ResponseEntity<Optional<Customer>> searchCustomer(@PathVariable("id") String id) throws Exception {
    Optional<Customer> customer = customerService.searchCustomer((id));
    return ResponseEntity.ok(customer);
  }

  @Override
  @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<String> deleCustomer(@PathVariable("id") String id) throws Exception {
    return ResponseEntity.ok(customerService.deleteCustomer((id)));
  }

  @RequestMapping(value = "/all", method = RequestMethod.GET)
  public ResponseEntity<List<Customer>> findAllCustomer() {
    return ResponseEntity.ok(customerService.findAllCustomer());
  }

  @Override
  @RequestMapping(value = "/update", method = RequestMethod.PUT)
  public ResponseEntity<Customer> updateCustomer(UpdateCustomerDto updateCustomerDto) throws Exception {
    Customer customer = customerService.updateCustomer(updateCustomerDto);
    return ResponseEntity.status(200).body(customer);
  }
}
