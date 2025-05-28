package org.example;

import java.util.Scanner;
import org.example.model.CoffeeMachine;
import org.example.model.enums.CoffeeType;
import org.example.model.exception.TokenException;

public class Main {
  public static void main(String[] args) {
    var scanner = new Scanner(System.in);
    var coffeeMachine = new CoffeeMachine();

    while (true) {
      System.out.print("Enter jetons to buy a coffee: ");
      var jetonsInput = scanner.nextLine();

      try {
        var jetons = Integer.parseInt(jetonsInput);
        coffeeMachine.insertJetons(jetons);

        System.out.println("Enter the name of your coffee: ");
        displayCoffeeTypes();
        System.out.print("> ");
        var coffeeNameInput = scanner.nextLine();
        var milk = handleOptions("milk", scanner);
        var sugar = handleOptions("sugar", scanner);
        var topping = handleTopping(scanner);

        var coffee = coffeeMachine.makeCoffee(coffeeNameInput, milk, sugar, topping);
        System.out.println("Coffee: " + coffee.getName());
        break;
      } catch (NumberFormatException e) {
        System.out.println("Invalid number");
        break;
      } catch (IllegalArgumentException e) {
        System.out.println("Selected coffee is unavailable");
        break;
      } catch (TokenException e){
        System.out.println("Insufficient tokens");
        break;
      }
    }
  }

  private static void displayCoffeeTypes() {
    for (CoffeeType t : CoffeeType.values()) {
      System.out.println(t.getValue());
    }
  }

  private static String handleTopping(Scanner scanner) {
    System.out.println("With cream ?: ");
    System.out.print("> ");
    String input = scanner.nextLine();

    String topping = null;
    if (input.equals("Y")) {
      topping = "cream";
    }
    return topping;
  }

  private static boolean handleOptions(String toHandle, Scanner scanner) {
    String message = "";

    if (toHandle.equals("milk")) {
      message = "With milk ? (Y/N)";
    } else if (toHandle.equals("sugar")) {
      message = "With sugar ? (Y/N)";
    }

    System.out.println(message);
    System.out.print("> ");
    String input = scanner.nextLine();

    boolean option;
    if (input.equals("Y")) {
      option = true;
    } else if (input.equals("N")) {
      option = false;
    } else throw new IllegalArgumentException("Unexpected value '" + input + "'");
    return option;
  }
}
