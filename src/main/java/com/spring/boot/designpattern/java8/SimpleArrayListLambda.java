package com.spring.boot.designpattern.java8;

import java.util.ArrayList;
import java.util.List;

public class SimpleArrayListLambda {

    public static void removeEvenNumbers(){
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5));

        //print the count of items in the stream
        System.out.println(list);

        //This lambda expression removes the even numbers from the list
        list.removeIf(integer -> integer % 2 == 0);

        //print the count of the items in the stream
        System.out.println(list);

    }
}
