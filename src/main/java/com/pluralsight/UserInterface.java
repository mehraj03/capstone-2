package com.pluralsight;
import java.awt.*;
import java.util.Scanner;
public class UserInterface {
    private  Scanner scanner;
    public UserInterface() {
        this.scanner = new Scanner(System.in);
    }
    public void displayHomeScreen() {
        boolean running = true;
        while (running) {
            System.out.println();
            System.out.println("===== DELI-cious =====");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            System.out.println("Choose an option: ");
            String choice = scanner.nextLine();
            if (choice.equals("1")) {
                displayOrderScreen();
            } else if (choice.equals("0")) {
                running = false;
                System.out.print("goodbye!");
            } else {
                System.out.println("Invalid option");
            }
        }
    }
    private void displayOrderScreen() {
        Order order = new Order();
        boolean ordering = true;

        while (ordering) {
            System.out.println();
            System.out.println("===== ORDER SCREEN =====");
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");
            System.out.println("Choose an option: ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                addsandwich(order);
            } else if (choice.equals("2")) {
                addDrink(order);
            } else if (choice.equals("3")) {
                addChips(order);
            } else if (choice.equals("4")) {
                checkout(order);
                ordering = false;
            } else if (choice.equals("0")) {
                System.out.println("Order cancelled.");
                ordering = false;
            } else {
                System.out.println("Invalid option.");
            }
        }
    }
    private void addsandwich(Order order) {
        System.out.println("select size (4, 8, 12):");
        String size = scanner.nextLine();
        System.out.println("Select bread (white, rye, wrap): ");
        String bread = scanner.nextLine();

        Sandwich sandwich = new Sandwich(size, bread);

        System.out.println("Add a meat? (yes/no): ");
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            System.out.print("Meat (steak,ham,salami,roast beef, chicken, bacon): ");
            String meatName = scanner.nextLine();
            System.out.print("Extra meat? (yes/no): ");
            boolean extraMeat = scanner.nextLine().equalsIgnoreCase("yes");
            sandwich.setMeat(new Meat(meatName, size, extraMeat));
        }
        System.out.print(("Add a cheese? (yes/no): "));
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            System.out.print("Cheese (american, provolone, cheddar, swiss): ");
            String cheeseName = scanner.next();
            System.out.print("Extra cheese?(yes/no):    ");
            boolean extraCheese = scanner.nextLine().equalsIgnoreCase("yes");
            sandwich.setCheese((new Cheese(cheeseName,size,extraCheese)));
        }
        System.out.println("Regular toppings: lettuce, peppers, onions, tomatoes, jalapeños, cucumbers, pickles, guacamole, mushrooms");
        boolean addingToppings = true;
        while (addingToppings) {
            System.out.print("Add a regular topping (or type 'done'): ");
            String topping = scanner.nextLine();
            if (topping.equalsIgnoreCase("done")) {
                addingToppings = false;
            } else {
                sandwich.addRegularTopping(topping);
            }
        }
        System.out.println("Sauces: mayo, mustard, ketchup, ranch, thousand islands, vinaigrette");
        boolean addingSauces = true;
        while (addingSauces) {
            System.out.print("Add a sauce (or type 'done'): ");
            String sauce = scanner.nextLine();
            if (sauce.equalsIgnoreCase("done")) {
                addingSauces = false;
            } else {
                sandwich.addSauce(sauce);
            }
        }
        System.out.print("Toasted? (yes/no): ");
        sandwich.setToasted((scanner.nextLine().equalsIgnoreCase("yes")));

        order.addItem(sandwich);
        System.out.println("Sandwich added!");
    }
    private void addDrink(Order order) {
        System.out.print("Drink size (small,medium,large): ");
        String size = scanner.nextLine();
        order.addItem(new Drink(size));
        System.out.println("Drink added!");
    }
    private void  addChips(Order order) {
        System.out.println("Chips Type: ");
        String type = scanner.nextLine();
        order.addItem(new Chips(type));
        System.out.println("chips added!");
    }
    private  void  checkout(Order order) {
        System.out.println();
        System.out.println(order.getOrderDetails());
        System.out.println("Confirm order? (yes/no): ");
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            ReceiptFileManager fileManager = new ReceiptFileManager();
            fileManager.saveReceipt(order);
            System.out.println("Order confirmed!");
        } else {
            System.out.println("Order cancelled");
        }
    }
}
