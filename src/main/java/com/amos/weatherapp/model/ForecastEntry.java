package com.amos.weatherapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.io.Serializable;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ForecastEntry implements Serializable {

    private String timestamp;

    private double temperature;

    private double pressure;

    private int humidity;

    public String getTimestamp() {
        return this.timestamp;
    }

    @JsonSetter("dt")
    public void setTimestamp(long unixTime) {
        Date date = new Date(unixTime * 1000);
        //TODO take it out to layer responsible for front end model
        Format format = new SimpleDateFormat("dd/MM/yyyy HH'h'mm");
        timestamp = format.format(date);
    }

    public double getTemperature() {
        return this.temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    @JsonProperty("main")
    public void setMain(Map<String, Object> main) {
        setTemperature(Double.parseDouble(main.get("temp").toString()));
        setPressure(Double.parseDouble(main.get("pressure").toString()));
        setHumidity(Integer.parseInt(main.get("humidity").toString()));

    }


}