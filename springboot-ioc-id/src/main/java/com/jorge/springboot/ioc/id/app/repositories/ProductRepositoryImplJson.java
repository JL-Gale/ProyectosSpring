package com.jorge.springboot.ioc.id.app.repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jorge.springboot.ioc.id.app.models.Product;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ProductRepositoryImplJson implements IProductRepository{

    private List<Product> data;

    public ProductRepositoryImplJson() {
        Resource resource = new ClassPathResource("json/product.json");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            this.data = Arrays.asList(objectMapper.readValue(resource.getFile(), Product[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
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
