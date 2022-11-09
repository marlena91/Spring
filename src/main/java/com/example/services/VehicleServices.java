package com.example.services;

import com.example.beans.Song;
import com.example.interfaces.LogAspect;
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

    @LogAspect
    public String playMusic(boolean vehicleStarted, Song song) {
        return speakers.makeSound(song);
    }

    public String moveVehicle(boolean vehicleStarted) {
        return tyres.rotate();
    }

    public String applyBrake(boolean vehicleStarted){
        return tyres.stop();
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
