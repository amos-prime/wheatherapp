package com.amos.weatherapp.controllers;

import com.amos.weatherapp.model.ForecastEntry;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
public class WeatherController {

    @RequestMapping("/")
    public String redirect() {
        return "redirect:/forecast";
    }

    @GetMapping("/forecast")
    public String getWeatherForecast(Model model) {
        return "forecast";
    }
}
