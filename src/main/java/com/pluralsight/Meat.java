package com.pluralsight;

public class Meat  extends Topping {
    private boolean extra;

    public Meat(String name,String size, boolean extra) {
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
            price = 1.00;
        } else if (this.size.equals("8")) {
            price = 2.00;
        } else {
            price = 3.00;
        }

        if(this.extra) {
            if (this.size.equals("4")) {
                price = price + 0.50;
            } else if (this.equals("8")) {
                price = price + 1.00;
            } else {
                price = price + 1.50;
            }
        }
        return price;
    }
    @Override
    public String toString() {
        String result = this.name;
        if (this.extra) {
            result = result + "extra";
        }
        return result;
    }
}
