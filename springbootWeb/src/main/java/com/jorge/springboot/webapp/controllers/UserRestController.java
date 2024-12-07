package com.jorge.springboot.webapp.controllers;

import com.jorge.springboot.webapp.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserRestController {

    @GetMapping("/details1")
    public Map details() {
        User user = new User("Milton","Olivero");
        Map<String, Object> body = new HashMap<>();
        body.put("User", user);
        body.put("title", "Hello world");
        return body;
    }
}
