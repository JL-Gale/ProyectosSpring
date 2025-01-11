package com.jorge.springboot.ioc.id.app.services;

import com.jorge.springboot.ioc.id.app.models.Product;
import com.jorge.springboot.ioc.id.app.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("test")
public class ProductServiceImplTest1 implements IProductService{

    private IProductRepository repository;
    @Autowired
    private Environment environment;

    @Autowired
    public ProductServiceImplTest1(@Qualifier("productRepositoryImpl") IProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> finAll() {
        return repository.findAll().stream()
                .map(s -> {
//                    Product product = (Product) s.clone();
//                    product.setPrice(product.getPrice() + ((long)(product.getPrice() * environment.getProperty("config.iva", Double.class))));
//                    return product;

//                    ProductDto productDto = new ProductDto(s.getName(), s.getPrice());
//                    productDto.setPrice(s.getPrice() + ((long) (s.getPrice() * 0.19)));
//                    return productDto;

//                    Product product = new Product(s.getId(), s.getName(), s.getPrice());

                    s.setPrice(s.getPrice() + ((long)(s.getPrice() * environment.getProperty("config.iva", Double.class))));
                    return s;
                })
                .toList();
    }

    @Override
    public Product finById(Long id) {
        return repository.findById(id);
    }

    //La inyeccion de depentencias puede hacer por parametro, constructor o setter
//    @Autowired
//    public void setRepository(IProductRepository repository) {
//        this.repository = repository;
//    }
}
