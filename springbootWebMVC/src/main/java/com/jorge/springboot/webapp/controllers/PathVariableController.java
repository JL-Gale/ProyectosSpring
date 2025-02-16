package com.jorge.springboot.webapp.controllers;

import com.jorge.springboot.webapp.model.dto.ParamDto;
import com.jorge.springboot.webapp.model.dto.ParamMixDto;
import com.jorge.springboot.webapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
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

    @Value("#{'${config.listOfValues}'.toUpperCase().split(',')}")
    private List<String> valuesList;

    @Value("#{ '${config.listOfValues}'.toUpperCase()}")
    private String valuesString;

    @Value("#{ ${config.valuesMap}}")
    public Map<String, Object> valuesmMap;

    @Value("#{${config.valuesMap}.price}")
    private Integer price;

    @Value("#{${config.valuesMap}.details}")
    private String details;

    @Autowired
    private Environment environment;

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
        body.put("Message 2:", environment.getProperty("config.message"));
        body.put("Code", this.code);
        body.put("code 2", environment.getProperty("config.code"));
        body.put("code 3", Integer.valueOf(environment.getProperty("config.code")));
        body.put("code 4", environment.getProperty("config.code", Integer.class));
        body.put("ListOfValues", this.listOfValus);
        body.put("ValuesList", this.valuesList);
        body.put("Values String",this.valuesString);
        body.put("Values Map", this.valuesmMap);
        return body;
    }

    @GetMapping("/valuesmap")
    public Map valuesMap(@Value("#{ ${config.valuesMap}}") Map<String, Object> valuesmMap){
        return valuesmMap;
    }


    @GetMapping("/valuesmap/details")
    public Map details(){
        Map<String, Object> body = new HashMap<>();
        body.put("Details", this.details);
        return body;
    }


    @GetMapping("/valuesmap /price")
    public Map price(){
        Map<String, Object> body = new HashMap<>();
        body.put("Price", this.price);
        return body;
    }

}
