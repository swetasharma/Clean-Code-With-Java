package com.spring.boot.designpattern.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * How to use java8 lambda expression and method reference to sort elelemts of a collection
 * How to use Java 8 foreach() method
 */
public class SortElementsOfCollection {
    String[] nameArray = {
        "Barbara",
        "Sweta",
        "Rahul",
        "Robert",
        "Michael"
    };
    /**
     * How to sort using an anonymous inner class
     */
    /**
     * How to sort using lambda expression
     */

    private static void showLambdaExpression(String[] nameArray){
        System.out.println("Show Lambda Expression");
        //Make a copy of the array.
        String[] nameArrayCopy = Arrays.copyOf(nameArray, nameArray.length);

        //Sort using Lambda Expression
        Arrays.sort(nameArrayCopy, (s, t) -> s.compareToIgnoreCase(t));

        //print out the sorted contents as an array
        System.out.println(List.of(nameArrayCopy));

    }

    /**
     * How to sort using a method reference
     */
    private static void showMethodReference(String[] nameArray){
        //Make a copy of the array.
        String[] nameArrayCopy = Arrays.copyOf(nameArray, nameArray.length);

        //Sort using method reference
        Arrays.sort(nameArrayCopy, String::compareToIgnoreCase);

        //Print out the sorted contents using the Java 8 forEach() method.
        Stream.of(nameArrayCopy).forEach(System.out::print);
    }

    /**
     * How to sort using another method reference
     */

    private static void showMethodReferenceSecond(String[] nameArray){
        //Make a copy of the array
        String[] nameArrayCopy = Arrays.copyOf(nameArray, nameArray.length);

        //Sort using method reference
        Arrays.sort(nameArrayCopy, String::compareToIgnoreCase);

        //Print out the sorted contents using Java 8 foreach()
        List.of(nameArrayCopy).forEach(System.out::print);
    }
}
