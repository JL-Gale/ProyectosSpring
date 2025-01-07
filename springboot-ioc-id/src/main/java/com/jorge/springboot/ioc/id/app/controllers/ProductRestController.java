package com.jorge.springboot.ioc.id.app.controllers;


import com.jorge.springboot.ioc.id.app.models.Product;
import com.jorge.springboot.ioc.id.app.services.ProductServiceImpl;
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

    ProductServiceImpl productService = new ProductServiceImpl();

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
}
