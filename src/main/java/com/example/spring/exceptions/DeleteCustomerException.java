package com.example.spring.exceptions;

public class DeleteCustomerException extends Exception {
  public DeleteCustomerException(String message) {
    super(message);
  }
}