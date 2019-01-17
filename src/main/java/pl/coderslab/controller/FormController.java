package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/first")
public class FormController {

    @GetMapping(path = "/form")
    public String form() {
        return "form.jsp";
    }

    @PostMapping(path = "/form", produces = "text/html; charset=UTF-8")
    @ResponseBody
    public String form(@RequestParam String paramName) {
        return String.format("Podano wartość: %s", paramName);
    }


}
