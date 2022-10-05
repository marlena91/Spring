package com.example.main;

import com.example.beans.Vehicle;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Example {

    public static void main(String[] args) {

        var context = new ClassPathXmlApplicationContext("beans.xml");

        Vehicle vehicle = context.getBean(Vehicle.class);
        System.out.println("Vehicle name from String Context is: "+vehicle.getName());

    }
}
