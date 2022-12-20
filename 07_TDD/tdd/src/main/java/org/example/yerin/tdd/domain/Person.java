package org.example.yerin.tdd.domain;

public class Person {
    String name;
    double height;
    Home home = new Home();

    public Person(String name, double height) {
        this.name = name;
        this.height = height;
    }
}
