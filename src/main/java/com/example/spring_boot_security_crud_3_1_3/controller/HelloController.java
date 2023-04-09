package com.example.spring_boot_security_crud_3_1_3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HelloController {
    @GetMapping("/")
    public String homePage() {
        return "home";
    }


}
