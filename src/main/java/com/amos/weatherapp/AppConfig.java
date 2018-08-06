package com.amos.weatherapp;

import com.amos.weatherapp.domain.CityDetailsProvider;
import com.amos.weatherapp.model.CityDetails;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ComponentScan
@PropertySource("classpath:application.properties")
public class AppConfig {

    @Value("${openwhathermap.city.name.london}")
    String london;

    @Value("${openwhathermap.city.name.newyork}")
    String newyork;

    @Value("${openwhathermap.city.name.washington}")
    String washington;

    @Value("${openwhathermap.city.id.london}")
    String londonId;

    @Value("${openwhathermap.city.id.newyork}")
    String newyorkId;

    @Value("${openwhathermap.city.id.washington}")
    String washingtonId;

    @Bean
    public CityDetailsProvider cityDataProvider() {
        Map<String, CityDetails> data = new HashMap<String, CityDetails>();
        data.put("london", new CityDetails(london, londonId));
        data.put("new york", new CityDetails(newyork, newyorkId));
        data.put("washington", new CityDetails(washington, washingtonId));

        return new CityDetailsProvider(data);
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
