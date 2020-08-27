package com.spring.boot.designpattern;

import java.util.Objects;

public class Person {
    private long idNumber;

    private String name;

    public Person(long idNumber,String name){
        this.idNumber = idNumber;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {

        if(this == obj){
            return true;
        }

        if(obj == null){
            return false;
        }

        if(this.getClass() != obj.getClass()){
            return false;
        }

        /*Person person = (Person) obj;
        return Objects.equals(this.name, person.name);*/

        Person person = (Person) obj;
        return this.idNumber == person.idNumber;
    }
}
