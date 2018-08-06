package com.amos.weatherapp.domain;

public class NoSuchCityExcetion extends RuntimeException {

    public NoSuchCityExcetion(String message) {
        super(message);
    }
}
