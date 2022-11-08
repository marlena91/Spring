package com.example.services;

import com.example.beans.Song;
import com.example.interfaces.Speakers;
import com.example.interfaces.Tyres;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
//@Scope(BeanDefinition.SCOPE_SINGLETON)
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class VehicleServices {

    private Logger logger = Logger.getLogger(VehicleServices.class.getName());

    @Autowired
    private Speakers speakers;
    private Tyres tyres;

    public VehicleServices() {
        System.out.println("VehicleServices object is created");
    }

    public String playMusic(boolean vehicleStarted, Song song) {
        Instant start = Instant.now();
        logger.info("Method execution start");
        String music = null;
        if (vehicleStarted) {
            music = speakers.makeSound(song);
        } else {
            logger.log(Level.SEVERE, "Vehicle not started to perform the operation");
        }
        logger.info("method execution end");
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        logger.info("Time took to execute the method : " + timeElapsed);
        return music;
    }

    public String moveVehicle(boolean vehicleStarted) {
        Instant start = Instant.now();
        logger.info("Method execution start");
        String status = null;
        if (vehicleStarted) {
            status = tyres.rotate();
        } else {
            logger.log(Level.SEVERE, "Vehicle not started to perform the operation");
        }
        logger.info("method execution end");
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        logger.info("Time took to execute the method : " + timeElapsed);
        return status;
    }

    public String applyBrake(boolean vehicleStarted){
        Instant start = Instant.now();
        logger.info("Method execution start");
        String status = null;
        if (vehicleStarted) {
            status = tyres.stop();
        } else {
            logger.log(Level.SEVERE, "Vehicle not started to perform the operation");
        }
        logger.info("method execution end");
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        logger.info("Time took to execute the method : "+timeElapsed);
        return status;
    }

    public Speakers getSpeakers() {
        return speakers;
    }

    public void setSpeakers(Speakers speakers) {
        this.speakers = speakers;
    }

    public Tyres getTyres() {
        return tyres;
    }

    @Autowired
    public void setTyres(Tyres tyres) {
        this.tyres = tyres;
    }
}
