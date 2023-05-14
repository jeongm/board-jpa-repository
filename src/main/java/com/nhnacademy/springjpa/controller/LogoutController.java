package com.nhnacademy.springjpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@Controller
@RequestMapping("/logout")
public class LogoutController {
    @GetMapping
    public String postLogout(HttpServletRequest request){
        HttpSession session = request.getSession(false);

        if(Objects.nonNull(session)) {
            session.invalidate();
        }

        return "redirect:/login";
    }

}
