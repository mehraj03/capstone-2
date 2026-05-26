package com.pluralsight;

public class Program {
    public static void main(String[] args) {
       Order order = new Order();

       order.addItem(new Drink("medium"));
       order.addItem(new Drink("large"));
       order.addItem(new Chips("BBQ"));

       System.out.println(order.getOrderDetails());
    }
}
