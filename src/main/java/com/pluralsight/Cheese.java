package com.pluralsight;

public class Cheese extends Topping {
    private boolean extra;

    public Cheese(String name, String size, boolean extra) {
        super(name, size);
        this.extra = extra;
    }
    public boolean isExtra() {
        return this.extra;
    }
    public void setExtra(boolean extra) {
        this.extra = extra;
    }
    @Override
    public double getPrice() {
        double price;
        if (this.size.equals("4")) {
            price = 0.75;
        } else if (this.size.equals("8")) {
            price = 1.50;
        } else {
            price = 2.25;
        }

        if (this.extra) {
            if (this.size.equals("4")) {
                price = price + 0.30;
            } else if (this.size.equals("8")) {
                price = price + 0.60;
            } else {
                price = price + 0.90;
            }
        }
        return price;
    }
    @Override
    public String toString() {
        String result = this.name;
        if (this.extra) {
            result = result + "(extra)";
        }
        return result;
    }

}
