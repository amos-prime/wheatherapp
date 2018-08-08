package com.amos.weatherapp.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class ApiAvailabilityServiceImplTest {

    private ApiAvailabilityServiceImpl apiAvailabilityService;

    @Before
    public void setUp() throws Exception {
        apiAvailabilityService = new ApiAvailabilityServiceImpl();
    }

    @Test
    public void ApiAvailabilityService_isApiAvailable() {
        for(int i = 0; i < ApiAvailabilityServiceImpl.LIMIT_OF_CALLS; i++) {
            assertTrue(apiAvailabilityService.isApiAvailable());
            apiAvailabilityService.registerApiCall();
        }

        assertFalse(apiAvailabilityService.isApiAvailable());
    }

}