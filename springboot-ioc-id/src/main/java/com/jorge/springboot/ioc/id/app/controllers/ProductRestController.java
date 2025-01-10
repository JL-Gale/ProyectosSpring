package com.jorge.springboot.ioc.id.app.controllers;


import com.jorge.springboot.ioc.id.app.models.Product;

import com.jorge.springboot.ioc.id.app.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/product")
public class ProductRestController {

    private IProductService productService;

    @Autowired
    public ProductRestController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/test/{id}")
    public Map test(@PathVariable Long id) {
        Map<String, Product> body = new HashMap<>();
        body.put("Producto", productService.finById(id));
        return body;
    }

    @GetMapping("/test")
    public Map test2() {
        Map<String, List<Product>> body = new HashMap<>();
        body.put("lista de Productos", productService.finAll());
        return body;
    }

    //La inyeccion de depentencias puede hacer por paramaetro, constructor o setter
//    @Autowired
//    public void setProductService(IProductService productService) {
//        this.productService = productService;
//    }

//    @GetMapping("/single")
//    public List<Product> getSingle(){
//        return productService.getSingle();
//    }
}
