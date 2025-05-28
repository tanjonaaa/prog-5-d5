package org.example.model;

import org.example.model.enums.CoffeeType;

public class Coffee {
  private final CoffeeType type;
  private final boolean milk;
  private final boolean sugar;
  private final String topping;

  public Coffee(CoffeeType type, boolean milk, boolean sugar, String topping) {
    this.type = type;
    this.milk = milk;
    this.sugar = sugar;
    this.topping = topping;
  }
}
