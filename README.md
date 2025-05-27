# PROG5 Coffee Machine
This project aims to represent user interactions with an automated coffee machine using Java Classes

# Use case
1. This system is meant to be used in semi-public or closed environments like offices or university
2. It allows the students/employees to buy drinks using prepaid tokens on automatic coffee machines
3. Each user has a predefined amount of tokens at the start of the month
4. Users can get token bonuses as a reward or they can buy them

# Models
- User 
  - Properties:
    * `id`: unique identifier
    * `tokenCount`: tokens are used to get drinks from coffee machines
      * 1 token = 1 standard mug of any type of coffee (0.3L)
      * each user has 31 tokens per month (1 coffee per day)
      * `tokenCount` is automatically renewed every month and cannot be accumulated through several months
  - Methods
    * `getId()`: get the id of a user
    * `getTokenCount()`: get the token count of a user
    * `setTokenCount(count)`: sets the value of `tokenCount` of a user
- CoffeeMachine
  - Properties:
    * `id`: unique identifier
    * `waterBalance`: The remaining quantity (in liter) of water inside the machine, used to make coffee
    * `coffeCapsules`: The number of remaining coffee capsules inside the machine, a `Map` would be good
      * `capsuleType`: describes of the type of coffee `(BLACK_COFFEE, CAPPUCINO, etc)`
      * `number`: describes the remaining number of the specified capsule
  - Methods:
    * `fillWater(quantity)`: add water inside the machine
      * `quantity` cannot be negative, else throws `IllegalArgumentException`
    * `getCoffee(coffeeType, quantity)`: get the specified quantity of the specified coffee type inside the machine
      * a capsule is consumed per 1Liter of `quantity`
      * if `quantity` > `waterBalance`, throw a `RuntimeException` 
      * compute the required amount of capsule to process the order as `requiredCapsuleQuantity`
        - if `requiredCapsuleQuantity` > remaining quantity inside the machine, throw a `RuntimeException`
      * deduct the `requiredCapsuleQuantity` from the remaining quantity of the corresponding coffee type inside the machine
      * deduct `quantity` from `waterBalance`
    * `listCoffeeTypes()`: list all the available coffee types inside the machine
      * if a specified type isn't available anymore (quantity inside `coffeeCapsules` <= 0), do not display in list
- CoffeeCapsuleTypeEnum: enum that describes all the possible coffee types available inside the machine
  * BLACK_COFFEE,
  * CAPPUCCINO,
  * LATTE,...
- CoffeeAppManager
  - Properties:
    * `users`: list of all users (university students, employees,...) 
      * adapt using a database and repositories later on
    * `coffeeMachines`: list of all available coffee machines, if a machine is broken, remove it
  - Methods:
    * `buyDrink(userId, machineId, coffeeType, tokenQuantity)`: users use their prepaid tokens to buy drinks
      * calculate the quantity in liters from the `tokenQuantity` as `quantityInLiters`
      * call `CoffeeMachine.getCoffee(coffeeType, quantityInLiters)`
      * set the user's new `tokenCount`
