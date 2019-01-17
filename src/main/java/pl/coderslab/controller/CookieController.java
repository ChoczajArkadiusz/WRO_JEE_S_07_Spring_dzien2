package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class CookieController {

    @GetMapping(path = "/setcookie/{value1}/{value2}", produces = "text/html; charset=UTF-8")
    @ResponseBody
    public String setCookie(@PathVariable String value1, @PathVariable String value2,
                            HttpServletResponse response) {
        Cookie cookie1 = new Cookie("cookie1", value1);
        Cookie cookie2 = new Cookie("cookie2", value2);
        cookie1.setPath("/");
        cookie2.setPath("/");
        response.addCookie(cookie1);
        response.addCookie(cookie2);
        return "dodano cookies";
    }

    @GetMapping(path = "/getcookies", produces = "text/html; charset=UTF-8")
    @ResponseBody
    public String setCookie(HttpServletRequest request, @CookieValue("cookie2") String cookie2Val) {
        Cookie cookie1 = WebUtils.getCookie(request, "cookie1");

        StringBuilder sb = new StringBuilder();
        sb.append("Wartości ciasteczek:<br>");
        sb.append(" - Cookie1: ").append(cookie1.getValue()).append("<br>");
        sb.append(" - Cookie2: ").append(cookie2Val).append("<br>");
        return sb.toString();
    }


}
