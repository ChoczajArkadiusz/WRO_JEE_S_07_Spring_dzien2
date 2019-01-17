package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

@Controller
public class FreeTimeController {

    @RequestMapping(path = "/free-time", produces = "text/html; charset=UTF-8")
    @ResponseBody
    public String freeTime () {
        LocalDateTime dateTime = LocalDateTime.now();

//        dateTime = dateTime.plusHours(8);
//        dateTime = dateTime.plusDays(3);

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Aktualna data: %s<br>Aktualny czas: %s<br>Dzień tygodnia: %s<br>",
                dateTime.toLocalDate(), dateTime.toLocalTime(), dateTime.getDayOfWeek()));

        if (dateTime.getDayOfWeek() == DayOfWeek.SATURDAY || dateTime.getDayOfWeek() == DayOfWeek.SUNDAY) {
            sb.append("<br>Wolne :D<br>");
        } else {
            sb.append("<br>Dzień roboczy<br>");
            if (dateTime.getHour() > 9 && dateTime.getHour() < 17) {
                sb.append("Pracuję, nie dzwoń.<br>");
            } else {
                sb.append("Po pracy :)<br>");
            }
        }
        return sb.toString();
    }


}
