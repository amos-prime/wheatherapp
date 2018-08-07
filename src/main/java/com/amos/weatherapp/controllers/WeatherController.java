package com.amos.weatherapp.controllers;

import com.amos.weatherapp.model.ForecastEntry;
import com.amos.weatherapp.model.WeatherForecast;
import com.amos.weatherapp.services.WeatherForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class WeatherController {

    private WeatherForecastService weatherForecastService;

    @Autowired
    public WeatherController(WeatherForecastService weatherForecastService) {
        this.weatherForecastService = weatherForecastService;
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/forecast/{city}")
    public String getWeatherForecast(Model model, @PathVariable String city) {
        WeatherForecast forcast = weatherForecastService.getForecastFor(city);
        model.addAttribute("cityName", forcast.getCityName());
        model.addAttribute("weatherEntries", forcast.getEntries());
        return "forecast";
    }
}
