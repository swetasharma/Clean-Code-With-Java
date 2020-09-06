package com.spring.boot.designpattern.java8;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Remove string matching for the list of strings
 */
public class RemoveString {

    static List<String> stringOld(List<String> lines, String remove){
        List<String> result = new ArrayList<>();
        for(String line : lines){
            if(!remove.equals(line)){
                result.add(line);
            }
        }
        return result;
    }

    static List<String> stringModern(List<String> lines, String remove) {
        return lines
                //convert the list to stream
                .stream()
                .filter(Predicate.not(remove::equals))
                //Trigger intermediate operation processing and return new list of results
                .collect(Collectors.toList());

    }
}
