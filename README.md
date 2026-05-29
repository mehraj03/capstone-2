# DELI-cious 🥪

A console-based point-of-sales application for DELI-cious, a custom sandwich shop. Customers can fully customize their sandwiches, add drinks and chips, and receive a receipt when their order is complete.

This is my Capstone 2 project for the Year Up Pluralsight Java bootcamp, focused on demonstrating object-oriented design.

## Features

- Build custom sandwiches in 3 sizes (4", 8", 12") with 4 bread types
- Add 0 or 1 meat with the option for "extra meat" (premium pricing)
- Add 0 or 1 cheese with the option for "extra cheese" (premium pricing)
- Add multiple regular toppings, sauces, and sides — no duplicates allowed
- Toast the sandwich
- Add drinks (3 sizes) and chips to your order
- View the full order details with itemized pricing before checkout
- Confirm the order to automatically save a timestamped receipt to the `receipts` folder

## How to run

1. Clone this repo
2. Open the project in IntelliJ
3. Run `Program.java`
4. Follow the on-screen prompts

Receipts are saved to a `receipts/` folder in the project root, named by the date and time the order was placed (e.g., `20260528-143055.txt`).

## Class diagram

### Initial design
This was my starting point# DELI-cious 🥪

A console-based point-of-sales application for DELI-cious, a custom sandwich shop. Customers can fully customize their sandwiches, add drinks and chips, and receive a receipt when their order is complete.

This is my Capstone 2 project for the Year Up Pluralsight Java bootcamp, focused on demonstrating object-oriented design.

## Features

- Build custom sandwiches in 3 sizes (4", 8", 12") with 4 bread types
- Add 0 or 1 meat with the option for "extra meat" (premium pricing)
- Add 0 or 1 cheese with the option for "extra cheese" (premium pricing)
- Add multiple regular toppings, sauces, and sides — no duplicates allowed
- Toast the sandwich
- Add drinks (3 sizes) and chips to your order
- View the full order details with itemized pricing before checkout
- Confirm the order to automatically save a timestamped receipt to the `receipts` folder

## How to run

1. Clone this repo
2. Open the project in IntelliJ
3. Run `Program.java`
4. Follow the on-screen prompts

Receipts are saved to a `receipts/` folder in the project root, named by the date and time the order was placed (e.g., `20260528-143055.txt`).

## Class diagram

### Initial design
This was my starting point — designed before I wrote any code.

 

### Final design
As I built the project, my design evolved. The biggest changes were:
- Used `HashSet<String>` for regular toppings, sauces, and sides to prevent duplicates (per the P.O. clarification)
- Dropped the `flavor` field from Drink (per the P.O. clarification — customer pours their own drink)
- Used direct class fields for `meat` and `cheese` since the P.O. clarified a sandwich can have at most one of each

## OOP concepts used

- **Interface (`Priceable`)** — Implemented by Sandwich, Drink, and Chips. Lets the Order class call `getPrice()` on any item without knowing its type. Inspired by the Asset Manager exercise where we could call `getValue()` on anything.
- **Abstract class (`Topping`)** — Parent of Meat and Cheese. Forces children to implement their own `getPrice()` based on size and the "extra" flag.
- **Inheritance** — Meat and Cheese both extend Topping.
- **Polymorphism** — Order holds an `ArrayList<Priceable>` and totals everything by calling `getPrice()` on each item, regardless of type.
- **Encapsulation** — All fields private with public accessors.
- **Separation of concerns** — UI (UserInterface), business logic (Order, Sandwich), and persistence (ReceiptFileManager) are separated into different classes. Same architecture as the Car Dealership workshop.
- **HashSet** — Used for regular toppings, sauces, and sides to prevent duplicate entries.

## An interesting piece of code

The most satisfying piece is the Order's `getTotal()` method:

```java
public double getTotal() {
    double total = 0;
    for (Priceable item : this.items) {
        total = total + item.getPrice();
    }
    return total;
}
```

It looks simple, but it's doing a lot. Because Sandwich, Drink, and Chips all implement the Priceable interface, this loop works for any combination of items without needing to check what type each one is. Adding a new product type in the future (like cookies or coffee) wouldn't change this method at all — the new class would just need to implement Priceable.

## Project structur — designed before I wrote any code.


As I built the project, my design evolved. The biggest changes were:
- Used `HashSet<String>` for regular toppings, sauces, and sides to prevent duplicates (per the P.O. clarification)
- Dropped the `flavor` field from Drink (per the P.O. clarification — customer pours their own drink)
- Used direct class fields for `meat` and `cheese` since the P.O. clarified a sandwich can have at most one of each



## OOP concepts used

- **Interface (`Priceable`)** — Implemented by Sandwich, Drink, and Chips. Lets the Order class call `getPrice()` on any item without knowing its type. Inspired by the Asset Manager exercise where we could call `getValue()` on anything.
- **Abstract class (`Topping`)** — Parent of Meat and Cheese. Forces children to implement their own `getPrice()` based on size and the "extra" flag.
- **Inheritance** — Meat and Cheese both extend Topping.
- **Polymorphism** — Order holds an `ArrayList<Priceable>` and totals everything by calling `getPrice()` on each item, regardless of type.
- **Encapsulation** — All fields private with public accessors.
- **Separation of concerns** — UI (UserInterface), business logic (Order, Sandwich), and persistence (ReceiptFileManager) are separated into different classes. Same architecture as the Car Dealership workshop.
- **HashSet** — Used for regular toppings, sauces, and sides to prevent duplicate entries.

## An interesting piece of code

The most satisfying piece is the Order's `getTotal()` method:

```java
public double getTotal() {
    double total = 0;
    for (Priceable item : this.items) {
        total = total + item.getPrice();
    }
    return total;
}
```
## Project structure
capstone-2/
├── src/main/java/com/pluralsight/
│   ├── Priceable.java          (interface)
│   ├── Topping.java            (abstract class)
│   ├── Meat.java
│   ├── Cheese.java
│   ├── Sandwich.java
│   ├── Drink.java
│   ├── Chips.java
│   ├── Order.java
│   ├── ReceiptFileManager.java
│   ├── UserInterface.java
│   └── Program.java
├── receipts/                    (auto-created when the first order is saved)
├── class-diagram-initial.png
├── README.md
└── pom.xml
It looks simple, but it's doing a lot. Because Sandwich, Drink, and Chips all implement the Priceable interface, this loop works for any combination of items without needing to check what type each one is. Adding a new product type in the future (like cookies or coffee) wouldn't change this method at all — the new class would just need to implement Priceable.

## Challenges I ran into

**Designing the topping hierarchy.** My original plan had a generic PremiumTopping class for both meat and cheese, but I realized they have different pricing tables (meat is $1.00–$3.00, cheese is $0.75–$2.25), so they really needed to be separate classes. Splitting them into Meat and Cheese made the code clearer even though it added a class.

**Handling the "newest items first" requirement.** The order screen needed to show items in reverse order. I considered adding items to the front of an ArrayList, but that's slow for big lists. Instead, I add to the end normally and iterate in reverse when displaying — same result, better performance.

**Building the receipt file path.** The receipt filename needed to be a timestamp formatted as `yyyyMMdd-HHmmss.txt`. I used `LocalDateTime.now()` with a `DateTimeFormatter` to build the filename, and added a check to create the `receipts/` folder if it doesn't exist yet so the program doesn't crash on the first run.

## What I'd improve next

**Signature sandwiches (the bonus).** The capstone offered an optional bonus to add pre-built sandwiches like a BLT or Philly Cheese Steak that customers could customize. I prioritized making the MVP rock-solid first, but signature sandwiches as a SignatureSandwich subclass of Sandwich would be a natural extension.

**Loading existing orders.** Right now ReceiptFileManager only writes — it doesn't read. An "admin mode" that loads past receipts and shows reports (total sales, most popular items) would be a real-world feature.

**Unit tests.** My professor mentioned that "the big girls" verify pricing with unit tests. I tested my pricing manually against a spreadsheet, but adding JUnit tests for the Sandwich and Order pricing logic would catch regressions if I ever changed the math.

**Cleaner menu navigation.** The sandwich builder is a long sequence of prompts. A more polished version would let the user go back and edit choices before finalizing the sandwich.

## Built with

- Java 17
- Maven
- IntelliJ IDEA
