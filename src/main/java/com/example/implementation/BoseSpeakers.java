package com.example.implementation;

import com.example.beans.Song;
import com.example.interfaces.Speakers;
import org.springframework.stereotype.Component;

@Component
public class BoseSpeakers implements Speakers {

    public String makeSound(Song song){
        return "Playing music -" + song.getTitle() + " " + song.getSingerName() +"- with Bose speakers";
    }

    @Override
    public String makeSound() {
        return "Playing music with Bose speakers";
    }
}
