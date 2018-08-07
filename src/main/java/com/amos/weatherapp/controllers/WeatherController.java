package com.amos.weatherapp.controllers;

import com.amos.weatherapp.domain.NoSuchCityExcetion;
import com.amos.weatherapp.model.WeatherForecast;
import com.amos.weatherapp.services.ForecastNotAvailableException;
import com.amos.weatherapp.services.WeatherForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String getWeatherForecast(Model model, @PathVariable String city) throws ForecastNotAvailableException {
        WeatherForecast forcast = weatherForecastService.getForecastFor(city);
        model.addAttribute("cityName", forcast.getCityName());
        model.addAttribute("weatherEntries", forcast.getEntries());
        return "forecast";
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private String cityNotFoundHandler(NoSuchCityExcetion ex, Model model) {
        model.addAttribute("message", ex.getMessage());
        return "error";
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private String ForecastNotFoundHandler(ForecastNotAvailableException ex, Model model) {
        model.addAttribute("message", "Our service is currently not available. Please try in 1 minute");
        return "error";
    }
}
