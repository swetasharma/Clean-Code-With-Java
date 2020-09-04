package com.spring.boot.designpattern.dependencyinjection;

public class Producer2 implements Producer{
    @Override
    public String purchaseStatus() {
        String purchaseSatus;
        purchaseSatus = "Item purchased successfully";
        return purchaseSatus;
    }
}
