package com.spring.boot.designpattern.lambda;

import java.util.ArrayList;
import java.util.List;

public class LambdaExpressions {
    public static Integer[] filterGreaterThan(int threshold, int[] array){
        List<Integer> greaterThanNumbers = new ArrayList<>();
        for(int number : array){
            if(number > threshold){
                greaterThanNumbers.add(number);
            }
        }
        return greaterThanNumbers.toArray(new Integer[greaterThanNumbers.size()]);
    }
}


