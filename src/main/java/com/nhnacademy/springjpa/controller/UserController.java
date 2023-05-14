package com.nhnacademy.springjpa.controller;

import com.nhnacademy.springjpa.domain.UserDto;
import com.nhnacademy.springjpa.domain.UserNotDetail;
import com.nhnacademy.springjpa.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String AdminMainView(){
        return "/admin/admin-page";
    }

    @GetMapping("/user-list")
    public String getUserList(Model model, Pageable pageable){

        List<UserNotDetail> users = userService.getUsers(pageable);
        model.addAttribute("userList",users);

        return "/admin/user-list";
    }

//    @GetMapping("/user-register")
//    public String userRegisterForm(Model model){
//        model.addAttribute("user",new UserRegisterRequest());
//        return "/admin/user-form";
//    }
//
//    @PostMapping("/user-register")
//    public String doUserRegister(@Valid @ModelAttribute("user") UserRegisterRequest userRegisterRequest,
//                                 BindingResult bindingResult,
//                                 HttpServletRequest request){
//        userService.userRegister(userRegisterRequest);
//        return "redirect:/board/user-view?userId=" + userRegisterRequest.getUserId();
//
//    }
//    @GetMapping("/user-update")
//    public String userUpdateForm(@RequestParam("userId") String userId, Model model){
//        User user = userService.getUserById(userId);
//        model.addAttribute("user",user);
//        return "/admin/user-form";
//    }
//
//    @PostMapping("/user-update")
//    public String doUserUpdate(@Valid @ModelAttribute("user") UserRegisterRequest userRegisterRequest,
//                               BindingResult bindingResult){
//        userService.userRegister(userRegisterRequest);
//        return "redirect:/board/user-view?userId=" + userRegisterRequest.getUserId();
//
//    }
//
//    @GetMapping("/user-view")
//    public String getUserInfo(@RequestParam("userId") String userId, Model model){
//
//        User user = userService.getUserById(userId);
//        model.addAttribute("user",user);
//
//        return "/board/user-view";
//    }
//
//    @DeleteMapping("/delete")
//    public ResponseEntity<Void> deleteUser(@RequestParam("userId") String userId){
//        userService.deleteUserById(userId);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }

}
