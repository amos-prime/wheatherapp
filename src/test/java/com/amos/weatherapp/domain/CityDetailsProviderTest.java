package com.amos.weatherapp.domain;

import com.amos.weatherapp.model.CityDetails;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations="classpath:application.properties")
public class CityDetailsProviderTest {

    @Value("${openweathermap.city.name.london}")
    String london;

    @Value("${openweathermap.city.name.newyork}")
    String newyork;

    @Value("${openweathermap.city.name.washington}")
    String washington;

    @Value("${openweathermap.city.id.london}")
    String londonId;

    @Value("${openweathermap.city.id.newyork}")
    String newyorkId;

    @Value("${openweathermap.city.id.washington}")
    String washingtonId;

    @Autowired
    CityDetailsProvider provider;

    @Test
    public void cityDetailsProvider_shouldReturnProperCityIDsForCityNames() {
        CityDetails cityDetailsLondon = provider.getDetailsFor("london");
        CityDetails cityDetailsNewYork = provider.getDetailsFor("new york");
        CityDetails cityDetailsWashington = provider.getDetailsFor("Washington");

        assertThat(cityDetailsLondon.getName()).isEqualTo(london);
        assertThat(cityDetailsLondon.getId()).isEqualTo(londonId);

        assertThat(cityDetailsNewYork.getName()).isEqualTo(newyork);
        assertThat(cityDetailsNewYork.getId()).isEqualTo(newyorkId);

        assertThat(cityDetailsWashington.getName()).isEqualTo(washington);
        assertThat(cityDetailsWashington.getId()).isEqualTo(washingtonId);

    }

    @Test(expected = NoSuchCityExcetion.class)
    public void cityDetailsProvider_shouldThrowNoSuchCityException() {
        CityDetails cityDetailsNewYork = provider.getDetailsFor("newyork");
    }

    @Test
    public void cityDetailsProvider_shouldWorkWithUppercaseLetters() {
        CityDetails cityDetailsNewYork = provider.getDetailsFor("New York");
        assertThat(cityDetailsNewYork.getName()).isEqualTo(newyork);
        assertThat(cityDetailsNewYork.getId()).isEqualTo(newyorkId);
    }

}
