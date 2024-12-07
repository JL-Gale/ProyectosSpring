package com.jorge.springboot.webapp.controllers;

import com.jorge.springboot.webapp.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/details")
    public String details(Model model) {
        User user = new User("Milton","Olivero");
        model.addAttribute("title", "Hello world");
        model.addAttribute("user", user);
        return "details";
    }
}
