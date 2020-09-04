package com.spring.boot.designpattern.dependencyinjection;

/**
 * Dependency Injection is a form of Inversion of control
 * Implementation of one object on which another object depends on,
 * is passed through setter, constructor etc
 */
public class Consumer1 {

    Producer1 producer1;

    public Consumer1(){
        producer1 = new Producer1();
    }

    public void purchaseItem(){
        String purchaseStatus;
        purchaseStatus = producer1.getItem();
        System.out.println(">> Purchase Status: " + purchaseStatus);
    }

}
