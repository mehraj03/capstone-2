package com.pluralsight;

public abstract class Topping {
    protected String name;
    protected String size;

    public Topping( String name, String size) {
        this.name = name;
        this.size = size;
    }
    public String getName() {
        return this.name;
    }
    public String getSize() {
        return this.size;
    }
    public abstract double getPrice();
}
