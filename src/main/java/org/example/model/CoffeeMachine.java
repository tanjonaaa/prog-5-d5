package org.example.model;

import org.example.model.enums.CoffeeType;
import org.example.model.exception.MachineNotReadyException;
import org.example.model.exception.TokenException;

public class CoffeeMachine {
  private int jetons;
  private boolean isPowered;
  private boolean hasWater;

  public CoffeeMachine() {
    this.jetons = 0;
    this.isPowered = true;
    this.hasWater = true;
  }

  public Coffee makeCoffee(String typeName, boolean milk, boolean sugar, String topping) {
    var coffeeType = CoffeeType.fromString(typeName);
    var coffee = new Coffee(coffeeType, milk, sugar, topping);
    var price = coffee.getPrice();

    if (price > jetons) {
      throw new TokenException("Insufficient tokens");
    }

    jetons -= price;

    return coffee;
  }

  public void insertJetons(int amount) {
    if (!isReady()) throw new MachineNotReadyException("Machine is not ready");

    jetons += amount;
  }

  public boolean isReady() {
    return isPowered && hasWater;
  }

  public void powerOff() {
    isPowered = false;
  }

  public void emptyWater() {
    hasWater = false;
  }

  public void reset() {
    jetons = 0;
    isPowered = true;
    hasWater = true;
  }
}
