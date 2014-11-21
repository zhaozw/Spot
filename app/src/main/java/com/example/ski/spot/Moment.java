package com.example.ski.spot;

/**
 * Created by kathy on 11/21/14.
 */
public class Moment {

    private String name;
    private String description;

    // ratings...
    // private int success
    // private int innovation
    // etc...

    public Moment(String name, String description) {

        this.name = name;
        this.description = description;

    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}