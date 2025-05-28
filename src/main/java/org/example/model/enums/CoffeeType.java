package org.example.model.enums;

import lombok.Getter;

@Getter
public enum CoffeeType {
  EXPRESSO("Expresso"),
  LATTE("Latte"),
  CAPPUCCINO("Cappuccino");

  private final String value;

  CoffeeType(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static CoffeeType fromString(String value) {
    for (CoffeeType b : CoffeeType.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}
