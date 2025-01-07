package com.jorge.springboot.ioc.id.app.services;

import com.jorge.springboot.ioc.id.app.models.Product;

import java.util.List;

public interface IProductService {
    List<Product> finAll();
    Product finById(Long id);
}
