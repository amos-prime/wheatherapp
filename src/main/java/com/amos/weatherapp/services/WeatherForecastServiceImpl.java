package com.amos.weatherapp.services;

import com.amos.weatherapp.domain.CityDetailsProvider;
import com.amos.weatherapp.model.CityDetails;
import com.amos.weatherapp.model.WeatherForecast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@PropertySource({"classpath:application.properties", "classpath:secret.properties"})
public class WeatherForecastServiceImpl implements WeatherForecastService {

    @Value("${openweathermap.api.url}")
    private String openWeatherMapUrl;

    @Value("${openweathermap.apikey}")
    private String apikey;

    private final RestTemplate restTemplate;

    private final CityDetailsProvider cityDetailsProvider;

    @Autowired
    public WeatherForecastServiceImpl(RestTemplate restTemplate, CityDetailsProvider cityDetailsProvider) {
        this.restTemplate = restTemplate;
        this.cityDetailsProvider = cityDetailsProvider;
    }

    @Override
    public WeatherForecast getForecastFor(String cityName) {
        CityDetails cityDetails = cityDetailsProvider.getDetailsFor(cityName);
        return restTemplate.getForEntity(openWeatherMapUrl, WeatherForecast.class, cityDetails.getId(), apikey)
                .getBody();
    }
}
