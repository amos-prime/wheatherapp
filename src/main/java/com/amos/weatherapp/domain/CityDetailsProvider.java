package com.amos.weatherapp.domain;

import com.amos.weatherapp.model.CityDetails;

import java.util.Map;

public class CityDetailsProvider {

    Map<String,CityDetails> cityDetails;

    public CityDetailsProvider(Map<String,CityDetails> data) {
        this.cityDetails = data;
    }

    public CityDetails getDetailsFor(String cityName) {
        CityDetails cityDetails = this.cityDetails.get(cityName.toLowerCase());
        if(cityDetails == null) {
            throw new NoSuchCityExcetion(String.format("City name not allowed: %s", cityName));
        }

        return new CityDetails(cityDetails.getName(), cityDetails.getId());
    }

}
