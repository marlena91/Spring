package com.example.main;

import com.example.beans.Vehicle;
import com.example.config.ProjectConfig;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Random;
import java.util.function.Supplier;

public class Example {

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Vehicle mazda = context.getBean(Vehicle.class);
        mazda.setName("Mazda");
        Supplier<Vehicle> mazdaSupplier = () -> mazda;

        Supplier<Vehicle> audiSupplier = () -> {
          Vehicle audi = new Vehicle();
          audi.setName("Audi");
          return audi;
        };

        Random random = new Random();
        int randomNumber = random.nextInt(10);
        System.out.println("Random number = "+ randomNumber);

        if((randomNumber % 2) == 0){
            context.registerBean("Mazda", Vehicle.class, mazdaSupplier);
        } else {
            context.registerBean("Audi", Vehicle.class, audiSupplier);
        }

        Vehicle mazdaVehicle = null;
        Vehicle audiVehicle = null;

        try {
            mazdaVehicle = context.getBean("Mazda", Vehicle.class);
        } catch(NoSuchBeanDefinitionException noSuchBeanDefinitionException) {
            System.out.println("Error while creating mazda vehicle");
        }

        try {
            audiVehicle = context.getBean("Audi", Vehicle.class);
        } catch(NoSuchBeanDefinitionException noSuchBeanDefinitionException){
            System.out.println("Error while creating audi vehicle");
        }

        if(null != mazdaVehicle){
            System.out.println("Pogramming  Vehicle name from Spring Context is: " + mazdaVehicle.getName());
        } else {
            System.out.println("Pogramming  Vehicle name from Spring Context is: " + audiVehicle.getName());

        }

    }
}
