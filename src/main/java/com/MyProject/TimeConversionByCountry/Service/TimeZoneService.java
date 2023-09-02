package com.MyProject.TimeConversionByCountry.Service;

import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;

@Service
public class TimeZoneService {
    public List<String> getAllTimezones() {
        String[] timezoneIds = TimeZone.getAvailableIDs();
        return Arrays.asList(timezoneIds);
    }

}
