package com.eidiko;

import org.springframework.stereotype.Component;

@Component
public class Car {

    private final Engine engine;

    public Car(Engine engine) {

        this.engine = engine;
    }

    public void start() {

        System.out.println("CAR STARTED WITH: " + engine.getType());
    }
}
