package com.jorge.springboot.webapp.controllers;

import com.jorge.springboot.webapp.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class UserController {

    @GetMapping("/details")
    public String details(Model model) {
        User user = new User("Milton","Olivero");
//        user.setEmail("milton@laputa.porn");
        model.addAttribute("title", "Hello world");
        model.addAttribute("user", user);
        return "details";
    }

    @GetMapping("/list")
    public String lista(ModelMap model){
        List<User> list = Arrays.asList(
                new User("Luisa", "Montiel"),
                new User("Nidia", "Orozco", "Nidia@gmail.com"),
                new User("Jorge", "Gale", "jorge.@gmail.com"));
        model.addAttribute("title", "Lista de atributos");
        model.addAttribute("textoh1", "Lista de usarioss");
        model.addAttribute("users", list);
        return "list";
    }
}
