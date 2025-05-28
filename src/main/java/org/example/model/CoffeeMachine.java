package org.example.model;

public class CoffeeMachine {
  private int jetons;
  private boolean isPowered;
  private boolean hasWater;

  // TODO: implement
  public Coffee makeCoffee(String typeName, boolean milk, boolean sugar, String topping) {
    return null;
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
    isPowered = true;
    hasWater = true;
  }
}
