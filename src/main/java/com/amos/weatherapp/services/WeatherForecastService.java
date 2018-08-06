package com.amos.weatherapp.services;

import com.amos.weatherapp.model.WeatherDTO;
import com.amos.weatherapp.model.json.WeatherForecast;

public interface WeatherForecastService {

    public WeatherForecast getForecastFor(String cityName);
}
