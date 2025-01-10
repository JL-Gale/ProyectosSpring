package com.jorge.springboot.ioc.id.app.repositories;

import com.jorge.springboot.ioc.id.app.models.Product;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class ProductRepositoryImplTest1 implements IProductRepository{

    private List<Product> data;

    public ProductRepositoryImplTest1() {
        this.data = Arrays.asList(
                new Product(1l, "Arroz test1", 3500l),
                new Product(2l, "Caffe test1", 1000l),
                new Product(3l, "Panela test1", 2000l),
                new Product(4l, "Huevos test1", 900l),
                new Product(5l, "Platanos test1", 700l)
        );
    }

    @Override
    public List<Product> findAll() {
        return data;
    }

    @Override
    public Product findById(Long id) {
        return data.stream().filter(p->p.getId().equals(id)).findFirst().orElse(null);
    }
}
