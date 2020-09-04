package com.spring.boot.designpattern.dependencyinjection;

public class Producer1 {
    public String getItem(){
        String purchaseStatus;
        purchaseStatus = "Item purchased successfully";
        return purchaseStatus;
    }
}
