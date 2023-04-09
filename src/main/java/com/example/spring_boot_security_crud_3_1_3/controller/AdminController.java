package com.example.spring_boot_security_crud_3_1_3.controller;

import com.example.spring_boot_security_crud_3_1_3.model.User;
import com.example.spring_boot_security_crud_3_1_3.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserServiceImpl service;

    @Autowired
    public AdminController(UserServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/getAll")
    public String show(Model model) {
        model.addAttribute("users", service.getUserRepository().findAll());
        return "/index";
    }

    @GetMapping("/add")
    public String addUser(@ModelAttribute("user") User user) {
        return "add";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") User user) {
        service.getUserRepository().save(user);
        return "redirect:/admin/getAll";
    }

    @GetMapping("/edit")
    public String editUser(Model model, @RequestParam(value = "id",required = false) Long id) {
        model.addAttribute("user", service.getUserRepository().getById(id));
        return "edit";
    }
    @PostMapping("/edit")
    public String update(@ModelAttribute("user") User user){
        service.getUserRepository().saveAndFlush(user);
        return "redirect:/admin/getAll";
    }
    @PostMapping("/delete")
    public String delete(@RequestParam(value = "id",required = false) Long id){
        service.getUserRepository().deleteById(id);
        return "redirect:/admin/getAll";
    }

}
