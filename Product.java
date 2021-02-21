package com.company.homework;

import java.util.ArrayList;

public class Product {
    private int call;
    private String name;
    private String unit;

    public Product(String name, String unit) {
        this.call = 0;
        this.name = name;
        this.unit = unit;
    }

    public int getCall() {
        return call;
    }

    public void setCall(int call) {
        this.call = call;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
    public void delete(String name) {
        this.name = name;
    }
}
