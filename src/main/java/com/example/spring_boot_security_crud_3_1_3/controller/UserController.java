package com.example.spring_boot_security_crud_3_1_3.controller;

import com.example.spring_boot_security_crud_3_1_3.model.User;
import com.example.spring_boot_security_crud_3_1_3.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserServiceImpl service;


    @Autowired
    public UserController(UserServiceImpl service) {
        this.service = service;
    }

    @GetMapping()
    public String showUserInfo(Model model, Principal principal){
        model.addAttribute("user", service.getUserRepository().findByUsername(
                principal.getName()).get());
        return "userInfo";
    }
}
