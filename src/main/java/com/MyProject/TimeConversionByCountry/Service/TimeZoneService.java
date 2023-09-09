package com.MyProject.TimeConversionByCountry.Service;

import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Service
public class TimeZoneService {
    public List<String> getAllTimezones() {
        String[] timezoneIds = TimeZone.getAvailableIDs();
        return Arrays.asList(timezoneIds);
    }

    public String convertTime(String fromTimezone, String toTimezone, String inputTime) {
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        try {
            // Parse the input time
            LocalTime localTime = LocalTime.parse(inputTime, timeFormatter);

            // Convert input time to ZonedDateTime in the 'fromTimeZone'
            ZoneId fromZone = ZoneId.of(fromTimezone);
            ZonedDateTime fromDateTime = ZonedDateTime.now(fromZone).with(localTime);

            // Convert ZonedDateTime to the 'toTimeZone'
            ZoneId toZone = ZoneId.of(toTimezone);
            ZonedDateTime toDateTime = fromDateTime.withZoneSameInstant(toZone);

            // Format the result time
            String convertedTime = toDateTime.toLocalTime().format(timeFormatter);

            return convertedTime;
        } catch (Exception e) {
            return "Invalid input or timezone format.";
        }
    }
}
