package com.jorge.springboot.ioc.id.app.repositories;

import com.jorge.springboot.ioc.id.app.models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Primary
@Repository
public class ProductRepositoryImplTest2 implements IProductRepository{

    private List<Product> data;

    public ProductRepositoryImplTest2() {
        this.data = Arrays.asList(
                new Product(1l, "Arroz test2", 3500l),
                new Product(2l, "Caffe test2", 1000l),
                new Product(3l, "Panela test2", 2000l),
                new Product(4l, "Huevos test2", 900l),
                new Product(5l, "Platanos test2", 700l)
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
