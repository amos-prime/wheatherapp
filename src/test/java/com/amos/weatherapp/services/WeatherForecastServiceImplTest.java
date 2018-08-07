package com.amos.weatherapp.services;

import com.amos.weatherapp.domain.CityDetailsProvider;
import com.amos.weatherapp.model.CityDetails;
import com.amos.weatherapp.model.WeatherForecast;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations={"classpath:application.properties", "classpath:secret.properties"})
public class WeatherForecastServiceImplTest {

    @MockBean
    private CityDetailsProvider cityDetailsProvider;

    @Autowired
    private WeatherForecastService weatherForecastService;

    @Value("${openweathermap.city.name.london}")
    String london;

    @Value("${openweathermap.city.id.london}")
    String londonId;

    @Value("${openweathermap.api.url}")
    private String openWeatherMapUrl;

    @Test
    public void WeatheForecastService_shouldReturnForecastForGivenCity() {
        //arrange
        given(cityDetailsProvider.getDetailsFor(anyString())).willReturn(new CityDetails(london, londonId));

        //act
        WeatherForecast forecast = weatherForecastService.getForecastFor(london);

        //assert
        assertThat(forecast.getCityName()).isEqualTo(london);
        assertThat(forecast.getEntries().size()).isEqualTo(40);
        assertThat(forecast.getEntries().get(0).getHumidity()).isNotNull();
        assertThat(forecast.getEntries().get(0).getPressure()).isNotNull();
        assertThat(forecast.getEntries().get(0).getTemperature()).isNotNull();
    }


}
