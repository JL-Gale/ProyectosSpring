package com.jorge.springboot.errors.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AppController {

    @GetMapping("/index")
    public String index() {
        int value = 100/0;
        return "ok 200";
    }
}
