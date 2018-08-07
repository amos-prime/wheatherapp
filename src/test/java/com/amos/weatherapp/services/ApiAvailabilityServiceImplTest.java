package com.amos.weatherapp.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;

@RunWith(JUnit4.class)
public class ApiAvailabilityServiceImplTest {

    private ApiAvailabilityServiceImpl apiAvailabilityService;

    @Before
    public void setUp() throws Exception {
        apiAvailabilityService = new ApiAvailabilityServiceImpl();
    }

    @Test
    public void ApiAvailabilityService_isApiAvailable() {
        assertTrue(apiAvailabilityService.isApiAvailable());

        for(int i = 0; i < 60; i++) {
            apiAvailabilityService.registerApiCall();
        }

        assertFalse(apiAvailabilityService.isApiAvailable());
    }

}