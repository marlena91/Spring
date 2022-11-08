package com.example.implementation;

import com.example.interfaces.Tyres;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MichelinTyres implements Tyres {

        public String rotate(){
            return "Vehicle moving with Michelin tyres";
        }

    @Override
    public String stop() {
        return "Vehicle stop with Michelin tyres";
    }

}
