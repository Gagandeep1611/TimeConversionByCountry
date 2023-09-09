package com.MyProject.TimeConversionByCountry.Service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.MyProject.TimeConversionByCountry.Service.TimeZoneService;
public class TimeZoneServiceTest {

    @Test
    public void testValidTimeConversion() {
        TimeZoneService timeZoneService = new TimeZoneService();

        // Valid inputs: "Asia/Kolkata" (IST) to "America/New_York" (Eastern Time)
        String result = timeZoneService.convertTime("Asia/Kolkata", "America/New_York", "12:00");
        assertEquals("12:30", "12:30", result);
    }

    @Test
    public void testInvalidInputTime() {
        TimeZoneService timeZoneService = new TimeZoneService();

        // Invalid input time format
        String result = timeZoneService.convertTime("Asia/Kolkata", "America/New_York", "invalidTime");
        assertEquals("Invalid input or timezone format.", "Invalid input or timezone format.", result);
    }

    @Test
    public void testInvalidTimeZone() {
        TimeZoneService timeZoneService = new TimeZoneService();

        // Invalid time zone identifiers
        String result = timeZoneService.convertTime("InvalidTimeZone", "AnotherInvalidTimeZone", "12:00");
        assertEquals("Invalid input or timezone format.", "Invalid input or timezone format.", result);
    }
}
