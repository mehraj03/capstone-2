package com.pluralsight;

import java.util.ArrayList;

public class Order {
    private ArrayList<Priceable> items;

    public Order() {
        this.items = new ArrayList<Priceable>();
    }
    public void addItem(Priceable item) {
        this.items.add(item);
    }
    public ArrayList<Priceable> getItems() {
        return this.items;
    }
    public double getTotal() {
        double total = 0;
        for (Priceable item : this.items) {
            total = total + item.getPrice();
        }
        return total;
    }
    public  String getOrderDetails() {
        String details = "==== ORDER DETAIL ====\n";
        for (int i = this.items.size() -1; i >= 0; i--) {
            details = details + this.items.get(i). toString() + "\n";
        }
        details = details + "---------------\n";
        details = details + "Total: $" + getTotal() + "\n";
        return details;
    }

}
