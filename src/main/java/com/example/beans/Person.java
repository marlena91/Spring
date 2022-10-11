package com.example.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
    @Autowired
    public Person(Vehicle vehicle){
        System.out.println("Person bean created by spring");
        this.vehicle = vehicle;
    }

    private String name = "Lucy";

    private Vehicle vehicle;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Vehicle getVehicle(){
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle){
        this.vehicle = vehicle;
    }

}
