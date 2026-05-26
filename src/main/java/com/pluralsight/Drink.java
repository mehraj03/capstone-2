package com.pluralsight;

public class Drink implements Priceable {
    private String size;

    public Drink(String size) {
        this.size = size;
    }
    public String getSize() {
        return this.size;
    }
    public void setSize(String size) {
        this.size = size;
    }
    @Override
    public double getPrice() {
        if (this.size.equalsIgnoreCase("small")) {
            return 2.00;
        } else if (this.size.equalsIgnoreCase("medium")) {
            return 2.50;
        } else {
            return 3.00;
        }
    }
    @Override public String toString() {
        return this.size + "drink - $" + getPrice();
    }
}
