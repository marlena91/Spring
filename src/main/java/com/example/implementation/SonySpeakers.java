package com.example.implementation;


import com.example.beans.Song;
import com.example.interfaces.Speakers;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class SonySpeakers implements Speakers {

    public String makeSound() {
        return "Playing music with Sony speakers";
    }

    @Override
    public String makeSound(Song song) {
        return "Playing music -" + song.getTitle() + " " + song.getSingerName() +"- with Sony speakers";

    }
}
