package com.amos.weatherapp.controllers;

import com.amos.weatherapp.domain.NoSuchCityExcetion;
import com.amos.weatherapp.services.ForecastNotAvailableException;
import com.amos.weatherapp.services.WeatherForecastService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(WeatherController.class)
public class WeatherControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    WeatherForecastService weatherForecastService;

    @Test
    public void weatherController_handleNoSuchCityException() throws Exception, ForecastNotAvailableException {
        given(weatherForecastService.getForecastFor(anyString())).willThrow(NoSuchCityExcetion.class);

        mvc.perform(MockMvcRequestBuilders.get("/forecast/lalala"))
                .andExpect(status().isNotFound());
    }
}