package com.jorge.springboot.ioc.id.app.repositories;

import com.jorge.springboot.ioc.id.app.models.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    Product findById(Long id);
}
