package com.MyProject.TimeConversionByCountry.Service;

import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    public String convertTime(String fromTimezone, String toTimezone, String time) {
        try {
            // Create SimpleDateFormat instances for parsing and formatting
            SimpleDateFormat inputFormat = new SimpleDateFormat("HH:mm");
            SimpleDateFormat outputFormat = new SimpleDateFormat("HH:mm");

            // Set the time zones for parsing and formatting
            inputFormat.setTimeZone(TimeZone.getTimeZone(fromTimezone));
            outputFormat.setTimeZone(TimeZone.getTimeZone(toTimezone));

            // Parse the input time string into a Date object
            Date date = inputFormat.parse(time);

            // Format the Date object to the target time zone
            String convertedTime = outputFormat.format(date);



            return convertedTime;
        } catch (ParseException e) {
            e.printStackTrace();
            return "Invalid input time format.";
        }
    }
}
