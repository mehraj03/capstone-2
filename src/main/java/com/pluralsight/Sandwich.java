package com.pluralsight;

import java.util.HashSet;

public class Sandwich implements Priceable{
    private  String size;
    private String bread;
    private Meat meat;
    private Cheese cheese;
    private HashSet<String> regularToppings;
    private HashSet<String> sauces;
    private HashSet<String> sides;
    private boolean toasted;

    public Sandwich(String size, String bread) {
        this.size = size;
        this.bread = bread;
        this.meat = null;
        this.cheese = null;
        this.regularToppings = new HashSet<String>();
        this.sauces = new HashSet<String>();
        this.sides = new HashSet<String>();
        this.toasted = false;
    }

    public String getSize() {
        return this.size;
    }
    public String getBread() {
        return this.bread;
    }
    public void setMeat(Meat meat) {
        this.meat = meat;
    }
    public void setCheese( Cheese cheese) {
        this.cheese = cheese;
    }

    public Cheese getCheese() {
        return cheese;
    }
    public void addRegularTopping(String topping) {
        this.regularToppings.add(topping);
    }
    public void addSauce (String sauce) {
        this.sauces.add(sauce);
    }
    public void addSide(String side) {
        this.sides.add((side));
    }
    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }
    public boolean isToasted() {
        return this.toasted;
    }
    @Override
    public double getPrice() {
        double price;
        if (this.size.equals("4")) {
            price = 5.50;
        } else if (this.size.equals("8")) {
            price = 7.00;
        } else {
            price = 8.50;
        }
        if (this.meat !=null) {
            price = price + this.meat.getPrice();
        }
        if (this.cheese != null) {
            price = price + this.cheese.getPrice();
        }
        return price;
    }
    @Override
    public String toString() {
        String result = this.size + "\"" + this.bread + "sandwich - $" + getPrice() + "\n";
        if (this.meat != null) {
            result = result + "  Meat: " + this.meat.toString() + "\n";
        }
        if (this.cheese != null) {
            result = result + "   Cheese: " + this.cheese.toString() + "\n";
        }
        for (String topping : this.regularToppings) {
            result = result + "   Topping: " + topping + "\n";
        }
        for (String sause : this.sauces) {
            result = result + "   Sauce: " + sause + "\n";
        }
        for (String side : this.sides) {
            result = result + "   Side: " + side + "\n";
        }
        if (this.toasted) {
            result = result + "   Toasted\n";
        }
        return result;
    }
}
