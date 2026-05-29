# DELI-cious 🥪

A console-based point-of-sales application for DELI-cious, a custom sandwich shop. Customers can fully customize their sandwiches, add drinks and chips, and receive a printed receipt when their order is complete.

This is my Capstone 2 project for the Year Up Pluralsight Java bootcamp, focused on demonstrating object-oriented design.

## Features

- Build custom sandwiches in 3 sizes (4", 8", 12") with 4 bread types
- Add 0 or 1 meat with the option for "extra meat" (premium pricing)
- Add 0 or 1 cheese with the option for "extra cheese" (premium pricing)
- Add multiple regular toppings and sauces — no duplicates allowed
- Toast the sandwich
- Add drinks (3 sizes) and chips to the order
- View full order details with itemized pricing before checkout
- Confirm the order to automatically save a timestamped receipt to the `receipts` folder

## How to run

1. Clone this repo
2. Open the project in IntelliJ
3. Run `Program.java`
4. Follow the on-screen prompts

Receipts are saved to a `receipts/` folder in the project root, named by the date and time the order was placed (e.g., `20260528-143055.txt`).

## Class diagram

### Initial design (hand sketch)

Before writing any code, I sketched out the classes and relationships I thought I'd need. I started with an abstract Topping class (with RegularTopping and PremiumTopping subclasses) and the Priceable interface implemented by Sandwich, Drinks, and Chips.


### Final design

As I built the project and got clarifications from the P.O., my design evolved a bit:
- Used `HashSet<String>` for regular toppings and sauces to prevent duplicates (per the no-duplicate rule)
- Dropped the `flavor` field from Drink (the P.O. clarified that customers pour their own drinks)
- Replaced the generic `RegularTopping`/`PremiumTopping` subclasses with specific `Meat` and `Cheese` classes, since meat and cheese have different pricing rules
- A sandwich holds at most one Meat and one Cheese (per the "0 or 1" rule), so they're stored as direct fields, not in a list

The core architecture — Priceable interface, abstract Topping parent, Order managing all items, separation of UI from persistence — held up exactly as planned.

## OOP concepts used

- **Interface (`Priceable`)** — Implemented by Sandwich, Drink, and Chips. Lets the Order class call `getPrice()` on any item without knowing its type. Inspired by the Asset Manager exercise where we could call `getValue()` on anything.
- **Abstract class (`Topping`)** — Parent of Meat and Cheese. Forces children to implement their own `getPrice()` based on size and the "extra" flag.
- **Inheritance** — Meat and Cheese both extend Topping.
- **Polymorphism** — Order holds an `ArrayList<Priceable>` and totals everything by calling `getPrice()` on each item, regardless of type.
- **Encapsulation** — All fields private with public accessors.
- **Separation of concerns** — UI (UserInterface), business logic (Order, Sandwich), and persistence (ReceiptFileManager) are separated into different classes. Same architecture as the Car Dealership workshop.
- **HashSet** — Used for regular toppings and sauces to prevent duplicate entries.

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

It looks simple, but it's doing a lot. Because Sandwich, Drink, and Chips all implement the Priceable interface, this loop works for any combination of items without checking what type each one is. Adding a new product type in the future (like cookies or coffee) wouldn't change this method at all — the new class would just need to implement Priceable.

## Project structure

