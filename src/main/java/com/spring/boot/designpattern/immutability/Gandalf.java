package com.spring.boot.designpattern.immutability;

import java.util.List;

public class Gandalf extends Hobbit{
    private String hackedName;
    /**
     * All args constructor
     *
     * @param name
     * @param address
     * @param stuff
     */
    public Gandalf(String name, Address address, List<String> stuff) {
        super(name, address, stuff);
        hackedName = name;
    }

    public void hackTheImmutability(String newNameValue){
        hackedName = newNameValue;
        System.out.println("Immutability has been hacked!");
    }

    @Override
    public String getName() {
        return hackedName;
    }
}
