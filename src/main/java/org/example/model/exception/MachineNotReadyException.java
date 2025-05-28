package org.example.model.exception;

public class MachineNotReadyException extends RuntimeException {
  public MachineNotReadyException(String message) {
    super(message);
  }
}
