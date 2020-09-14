package com.spring.boot.designpattern.arraylistpractice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArrayListPractice {

    public static void main(String... args) {
        List<String> cars = new ArrayList<>();
        cars.add("Porsche");
        cars.add("Ferrari");
        cars.add("Lamborghini");

        for (String car : cars) {
            System.out.println(car);
        }
        cars.add(1, "Aston Martin");

        cars.forEach(System.out::println);

        cars.remove("Ferrari");
        cars.forEach(System.out::println);

        cars.remove(1);
        cars.forEach(System.out::println);

        cars.set(0, "Skyline");

        cars.forEach(System.out::println);

        System.out.println(cars.get(0));


        cars.clear();
        cars.forEach(System.out::println);

        //List.of method returns immutable list
        //immutable state cannot be changed after it is construcyed
        List<String> italianCars = List.of("Lamborghini", "Ferrari");
        //italianCars.remove("Lamborghini");

        List<String> globalCars = new ArrayList<>();
        globalCars.addAll(italianCars);
        globalCars.add("Porsche");
        globalCars.forEach(System.out::println);


        System.out.println("Copy on write arraylist");
        List<String> copyCars = new CopyOnWriteArrayList<>();
        copyCars.add("Porsche");
        copyCars.add("Lamborghini");
        copyCars.add("Aston Martin");
        copyCars.add("Skyline");

        copyCars.forEach(System.out::println);
        for (String car : copyCars){
            copyCars.add("Rolls-Royce");
            copyCars.remove(car);
        }
        
        copyCars.forEach(System.out::println);
    }
}
