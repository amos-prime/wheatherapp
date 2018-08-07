package com.amos.weatherapp.services;

import com.amos.weatherapp.model.WeatherForecast;

public interface WeatherForecastService {

    public WeatherForecast getForecastFor(String cityName) throws ForecastNotAvailableException;
}
