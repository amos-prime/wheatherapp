package com.amos.weatherapp.services;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ApiAvailabilityServiceImpl implements ApiAvailabilityService {

    public static final int LIMIT_OF_CALLS = 60;
    private List<LocalDateTime> history = new ArrayList<LocalDateTime>(LIMIT_OF_CALLS);

    @Override
    public boolean isApiAvailable() {
        if(history.size() < LIMIT_OF_CALLS || history.isEmpty()) {
            return true;
        } else if(isLastEntryOlderThanMinute()) {
            resetHistory();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void registerApiCall() {
        if(isLastEntryOlderThanMinute()) {
            resetHistory();
        }
        addCall();
    }

    private boolean isLastEntryOlderThanMinute() {
        if(history.isEmpty()) {
            return true;
        }
        LocalDateTime last = history.get(history.size() - 1);
        LocalDateTime now = LocalDateTime.now();
        return last.plusMinutes(1).isBefore(now);
    }

    private void addCall() {
        if(history.size() == LIMIT_OF_CALLS) {
            history.remove(0);
        }
        history.add(LocalDateTime.now());
    }

    private void resetHistory() {
        history.clear();
    }
}
