package com.spring.boot.designpattern.dependencyinjection;

/**
 * The class Consumer2 is not dependent on specific implementation of Producer2
 */
public class Consumer2 implements Consumer{

    Producer producer;

    public Consumer2(Producer producer){
        this.producer = producer;
    }

    @Override
    public String purchaseItem() {
        String purchaseStatus;
        purchaseStatus = producer.purchaseStatus();
        return purchaseStatus;
    }
}
