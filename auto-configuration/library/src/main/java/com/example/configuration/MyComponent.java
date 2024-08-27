package com.example.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyComponent {

    private String myProperty;

    public MyComponent(@Value("${mycomponent.myProperty}")String myProperty) {
        this.myProperty = myProperty;
    }

    public String getMyProperty() {
        return myProperty;
    }

    public void setMyProperty(String myProperty) {
        this.myProperty = myProperty;
    }

    public void doSomething() {
        System.out.println("Property value: " + myProperty);
    }
}
