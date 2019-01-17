package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

@Controller
@SessionAttributes({"loginStart"})
public class SessionController {

    @RequestMapping("/session")
    @ResponseBody
    public String session(HttpSession session, Model model) {
        Object attribute = session.getAttribute("loginStart");
        String loginStart;
        if (attribute == null ) {
            loginStart = LocalDateTime.now().toString();
            model.addAttribute("loginStart", loginStart);
        } else {
            loginStart = String.valueOf(attribute);
        }
        return loginStart;
    }


}
