package com.jorge.springboot.webapp.controllers;

import com.jorge.springboot.webapp.model.User;
import com.jorge.springboot.webapp.model.dto.UserDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserRestController {

    @GetMapping("/details-dto")
    public UserDto detailsDto() {
        User user = new User("JorgeDTO", "Gale");
        UserDto userDto = new UserDto();
        userDto.setUser(user);
        userDto.setTitle("Hola world desde un dto kkkk");
        return userDto;
    }

    @GetMapping("/details-map")
    public Map details() {
        User user = new User("Milton-map", "Olivero");
        Map<String, Object> body = new HashMap<>();
        body.put("User", user);
        body.put("title", "Hello world");
        return body;
    }

    @GetMapping("/details-list")
    public List<User> listaDeUser(){
        User user1 = new User("Milton-list", "Olivero");
        User user2 = new User("Jorge-list", "Gale");
        User user3 = new User("-Cecilialist", "Gale");
        User user4 = new User("Onalba-list", "Montiel");
        List<User> list = Arrays.asList(user1, user2, user3, user4);
        return list;
    }
}
