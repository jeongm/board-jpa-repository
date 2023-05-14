package com.nhnacademy.springjpa.controller;

import com.nhnacademy.springjpa.domain.LoginRequest;
import com.nhnacademy.springjpa.domain.Role;
import com.nhnacademy.springjpa.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Objects;

@Slf4j
@Controller
@RequestMapping("/login")
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String loginForm(Model model, HttpServletRequest request){
        if(Objects.nonNull(request.getSession().getAttribute("login"))){
            return "redirect:/board";
        }
        model.addAttribute("loginRequest",new LoginRequest());
        return "/login/login-form";
    }


    /**
     * model에 들어갈 수 있는 속성은 admin과 user이다.
     * @param loginRequest
     * @param bindingResult
     * @param request
     * @param redirectAttributes
     * @return
     */
    @PostMapping
    public String doLogin(@Valid @ModelAttribute LoginRequest loginRequest,
                          BindingResult bindingResult,
                          HttpServletRequest request,
                          RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            return "/login/login-form";
        }


        if(userService.getUserByUserId(loginRequest.getUserId()).getPosition().equals(Role.ADMIN)) {
            HttpSession session = request.getSession(true);
            //TODO 관리자 로그인 체크
            session.setAttribute("user",userService.getUserByUserId(loginRequest.getUserId()));
            return "redirect:/admin";
        }

        if (!userService.matches(loginRequest.getUserId(), loginRequest.getUserPassword())) {
            redirectAttributes.addFlashAttribute("message","로그인 실패");
            return "redirect:/login";

        } else {
            HttpSession session = request.getSession(true);
            session.setAttribute("user", userService.getUserByUserId(loginRequest.getUserId()));
            return "redirect:/board";
        }
    }
}
