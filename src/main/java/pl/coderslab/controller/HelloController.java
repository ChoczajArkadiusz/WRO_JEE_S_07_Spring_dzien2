package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

@Controller
public class HelloController {

    @RequestMapping(path = "/hello", produces = "text/html; charset=UTF-8")
    @ResponseBody
    public String helloWorld() {
        return "<h1>Hello World, Polskie znaki: Żółty</h1>";
    }

    @GetMapping(path = "/hello/{firstName}/{lastName}")
    @ResponseBody
    public String getUser(@PathVariable String firstName, @PathVariable String lastName) {
        return String.format("Witaj %s %s.", firstName, lastName);
    }

    @RequestMapping(path = "/helloView", produces = "text/html; charset=UTF-8")
    public String home(Model model) {
        String color = "white";
        String backgroundColor = "black";
        LocalDateTime dateTime = LocalDateTime.now();

        dateTime = dateTime.plusHours(12);
//        dateTime = dateTime.plusDays(3);

        if (dateTime.getHour() > 8 && dateTime.getHour() < 20) {
            color = "green";
            backgroundColor = "lightblue";
        }
        model.addAttribute("color", color);
        model.addAttribute("backgroundColor", backgroundColor);
        return "home";
    }


}
