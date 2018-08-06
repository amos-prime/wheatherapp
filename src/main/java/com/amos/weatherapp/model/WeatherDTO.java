package com.amos.weatherapp.model;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;


public class WeatherDTO {

    @JsonIgnore
    private Map<String, String> weatherDetails = new HashMap<String, String>();

    @JsonAnyGetter
    public Map<String, String> getWeatherDetails() {
        return this.weatherDetails;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, String value) {
        this.weatherDetails.put(name, value);
    }

}
