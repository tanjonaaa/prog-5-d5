package org.example.model;

import org.example.model.enums.CoffeeType;

public class Coffee {
  private static final int COFFEE_UNIT_PRICE_IN_JETONS = 1;
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

  public int getPrice() {
    var computedPrice = COFFEE_UNIT_PRICE_IN_JETONS;
    if (topping != null) {
      computedPrice += 1;
    }
    return computedPrice;
  }

  public String getName() {
    var nameBuilder = new StringBuilder();
    nameBuilder.append(type.getValue());
    if (milk || sugar || topping != null) {
      nameBuilder.append(" with");
      if (milk) nameBuilder.append(" milk");
      if (sugar) nameBuilder.append(" sugar");
      if (topping != null) nameBuilder.append(" ").append(topping);
    }
    return nameBuilder.toString();
  }
}
