package com.amos.weatherapp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

public class WeatherForecast implements Serializable {

    private String cityName;

    private List<ForecastEntry> entries = new ArrayList<>();

    public String getCityName() {
        return this.cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @JsonProperty("entries")
    public List<ForecastEntry> getEntries() {
        return this.entries;
    }

    @JsonSetter("list")
    public void setEntries(List<ForecastEntry> entries) {
        this.entries = entries;
    }

    @JsonProperty("city")
    public void setCity(Map<String, Object> city) {
        setCityName(city.get("name").toString());
    }

}
