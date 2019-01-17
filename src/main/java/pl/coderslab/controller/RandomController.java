package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@Controller
public class RandomController {

    @GetMapping(path = "/random", produces = "text/html; charset=UTF-8")
    @ResponseBody
    public String showRandom() {
        Random rand = new Random();
        return String.format("Wylosowano liczbę: %d", rand.nextInt(100) + 1);
    }


    @GetMapping(path = "/random-user", produces = "text/html; charset=UTF-8")
    @ResponseBody
    public String getRandom(@RequestParam int min, @RequestParam int max) {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        if (min < max) {
            sb.append(String.format("Wylosowano liczbę: %d", rand.nextInt(max - min + 1) + min));
        } else {
            sb.append("Nieprawidłowy zakres!!!");
        }

        return sb.toString();
    }


}
