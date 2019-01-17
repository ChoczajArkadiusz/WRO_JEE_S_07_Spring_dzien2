package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MultiplyController {

    @GetMapping("/multiply")
    public String multiply(Model model, @RequestParam(defaultValue = "10") int size) {
        int rows = size < 0 ? 0 : size;
        int cols = size < 0 ? 0 : size;
        model.addAttribute("rows", rows);
        model.addAttribute("cols", cols);
        return "multiply";
    }

    @GetMapping("/paramMultiply/{rows}/{cols}")
    public String multiply(Model model, @PathVariable int rows, @PathVariable int cols) {
        rows = rows < 0 ? 0 : rows;
        cols = cols < 0 ? 0 : cols;
        model.addAttribute("rows", rows);
        model.addAttribute("cols", cols);
        return "multiply";
    }
}
