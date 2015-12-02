package com.tempestronics.helpchennai.model;

/**
 * Created by Moz on 02/12/15.
 */
public class Doctor {

    String name, area, number;

    public Doctor(String name, String area, String number) {
        this.name = "Dr. " + name;
        this.area = area;
        this.number = "+91" + number;
    }

    public String getName() {
        return name;
    }

    public String getArea() {
        return area;
    }

    public String getNumber() {
        return number;
    }
}
