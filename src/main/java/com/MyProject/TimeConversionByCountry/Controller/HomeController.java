package com.MyProject.TimeConversionByCountry.Controller;


import com.MyProject.TimeConversionByCountry.Service.TimeZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private TimeZoneService timeZoneService;
    @GetMapping("/form")
    public String showForm(Model model) {
        List<String> timezones = timeZoneService.getAllTimezones();
        model.addAttribute("timezones", timezones);
        return "timezoneForm"; // Return the name of the HTML form (timezoneForm.html)
    }

    @PostMapping("/submit")
    public String submitForm(
            @RequestParam("FromTimezone") String FromTimezone,
            @RequestParam("ToTimezone") String ToTimezone,
            @RequestParam("time") String time,
            Model model) {
        // Use the selectedTimezone variable in your controller logic
        String convertedTime=timeZoneService.convertTime(FromTimezone,ToTimezone,time);
        System.out.println("Converted Time: "+ convertedTime);
        return "resultPage"; // Return the name of the result page (resultPage.html)
    }


}
