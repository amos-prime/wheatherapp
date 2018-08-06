package com.amos.weatherapp.model;

public class CityDetails {

    private String name;

    private String id;

    public CityDetails(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public String getId() {
        return id;
    }

}
