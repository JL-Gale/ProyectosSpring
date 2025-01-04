package com.jorge.springboot.webapp.controllers;

import com.jorge.springboot.webapp.model.dto.ParamDto;
import com.jorge.springboot.webapp.model.dto.ParamMixDto;
import com.jorge.springboot.webapp.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/var")
public class PathVariableController {

    @Value("${config.username}")
    private String username;

//    @Value("${config.message}")
//    private String message;

    @Value("${config.code}")
    private Integer code;

//    @Value("${config.listOfValues}")
//    private String[] listOfValus;

    @Value("${config.listOfValues}")
    private List<String> listOfValus;

    @Value("#{ '${config.listOfValues}'.toUpperCase().split(',')}")
    private List<String> valuesList;

    @Value("#{ '${config.listOfValues}'.toUpperCase()}")
    private String valuesString;

    @Value("#{ ${config.valuesMap}}")
    public Map<String, Object> valuesmMap;

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

    @GetMapping("/values")
    public Map values(@Value("${config.message}") String message){
        Map<String, Object> body = new HashMap<>();
        body.put("User Name", this.username);
        body.put("Message", message);
        body.put("Code", this.code);
        body.put("ListOfValues", this.listOfValus);
        body.put("ValuesList", valuesList);
        body.put("Values String",valuesString);
        body.put("Values Map", valuesmMap);
        return body;
    }

    @GetMapping("/valuesmap")
    public Map valuesMap(@Value("#{ ${config.valuesMap}}") Map<String, Object> valuesmMap){
        return valuesmMap;
    }
}
