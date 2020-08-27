package com.spring.boot.designpattern;

import java.util.List;

public class Hobbit {
    private String name;
    private Address address;
    private List<String> stuff;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<String> getStuff() {
        return stuff;
    }

    public void setStuff(List<String> stuff) {
        this.stuff = stuff;
    }
}
