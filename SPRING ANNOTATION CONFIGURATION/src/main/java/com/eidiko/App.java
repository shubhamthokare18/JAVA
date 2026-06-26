package com.eidiko;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.eidiko")
public class App {

    public static void main( String[] args ) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(App.class);
        Car car = applicationContext.getBean(Car.class);
        car.start();
    }
}
