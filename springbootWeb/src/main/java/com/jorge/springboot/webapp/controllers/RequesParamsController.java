package com.jorge.springboot.webapp.controllers;

import com.jorge.springboot.webapp.model.dto.ParamDto;
import com.jorge.springboot.webapp.model.dto.ParamMixDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/params")
public class RequesParamsController {

    @GetMapping("/foo")
    public ParamDto foo(@RequestParam (required = false,  defaultValue = "Esta vacio kbrom") String message){
        ParamDto paramDto = new ParamDto();
        paramDto.setMessage(message);
        return paramDto;
    }

    @GetMapping("/bar")
    public Map bar(@RequestParam(defaultValue = "vacio") String message, @RequestParam(defaultValue = "vacio") String code){
        Map<String, Object> body= new HashMap<>();
        body.put("Message", message);
        body.put("code", code);
        return body;
    }

    @GetMapping("/barParam")
    public ParamMixDto barParamMixDto(@RequestParam String message, @RequestParam Integer code){
        ParamMixDto paramMixDto = new ParamMixDto();
        paramMixDto.setMessage(message);
        return paramMixDto;
    }


    @GetMapping("/request")
    public ParamMixDto reques(HttpServletRequest request){
        ParamMixDto paramMixDto = new ParamMixDto();
        Integer code = null;
        try {
            code = Integer.parseInt(request.getParameter("code"));
        } catch (NumberFormatException e) {}
        paramMixDto.setMessage(request.getParameter("message"));
        paramMixDto.setCode(code);
        return paramMixDto;
    }
}
