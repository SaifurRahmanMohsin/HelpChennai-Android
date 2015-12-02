package com.tempestronics.helpchennai.model;

/**
 * Created by Moz on 02/12/15.
 */
public class Emergency {

    String name, number;

    public Emergency(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }
}
