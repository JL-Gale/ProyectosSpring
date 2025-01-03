package com.jorge.springboot.webapp.controllers;

import com.jorge.springboot.webapp.model.dto.ParamDto;
import com.jorge.springboot.webapp.model.dto.ParamMixDto;
import com.jorge.springboot.webapp.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/var")
public class PathVariableController {

    @GetMapping("/baz/{message}")
    public ParamDto baz(@PathVariable String message){
        ParamDto paramDto = new ParamDto();
        paramDto.setMessage(message);
        return paramDto;
    }

    @GetMapping("/param/{message}/{code}")
    public ParamMixDto bazParamMix(@PathVariable String message, @PathVariable Integer code){
        ParamMixDto paramMixDto = new ParamMixDto();
        paramMixDto.setMessage(message);
        paramMixDto.setCode(code);
        return paramMixDto;
    }

    @GetMapping("/bazmap/{product}/{code}")
    public Map bazMap(@PathVariable String product, @PathVariable String code){
        Map<String, Object> body = new HashMap<>();
        body.put("Product", product);
        body.put("Code", code);
        return body;
    }

    @PostMapping("/create")
    public User postParamMix(@RequestBody User user){
        //Hacer algo con el usuario save a bbdd
        return user;
    }
}
