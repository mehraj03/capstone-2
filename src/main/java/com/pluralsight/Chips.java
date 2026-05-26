package com.pluralsight;

public class Chips implements  Priceable {
    private String type;

    public Chips(String type) {
        this.type = type;
    }
    public String getType() {
        return this.type;
    }
    public void setType(String type) {
        this.type = type;
    }
    @Override
    public double getPrice() {
        return 1.50;
    }
    @Override
    public String toString() {
        return this.type + "chips -$" + getPrice();
    }
}
