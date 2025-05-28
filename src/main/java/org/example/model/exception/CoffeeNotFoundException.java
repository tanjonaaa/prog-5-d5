package org.example.model.exception;

public class CoffeeNotFoundException extends RuntimeException {
  public CoffeeNotFoundException(String message) {
    super(message);
  }
}
