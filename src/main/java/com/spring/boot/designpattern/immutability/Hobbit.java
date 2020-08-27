package com.spring.boot.designpattern.immutability;

import java.util.List;

/**
 * Immutable classes in java
 * 1. Removing Setters
 * 2. Adding all args constructor
 */
public class Hobbit {

    private String name;
    private Address address;
    private List<String> stuff;

    /**
     * All args constructor
     * @param name
     * @param address
     * @param stuff
     */
    public Hobbit(String name, Address address, List<String> stuff){
        this.name = name;
        this.address = address;
        this.stuff = stuff;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public List<String> getStuff() {
        return stuff;
    }
}
