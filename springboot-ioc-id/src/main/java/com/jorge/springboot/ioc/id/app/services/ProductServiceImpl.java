package com.jorge.springboot.ioc.id.app.services;

import com.jorge.springboot.ioc.id.app.models.Product;
import com.jorge.springboot.ioc.id.app.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService{

    private IProductRepository repository;

    @Autowired
    public ProductServiceImpl(IProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> finAll() {
        return repository.findAll().stream()
                .map(s -> {
//                    ProductDto productDto = new ProductDto(s.getName(), s.getPrice());
//                    productDto.setPrice(s.getPrice() + ((long) (s.getPrice() * 0.19)));
//                    return productDto;

//                    Product product = new Product(s.getId(), s.getName(), s.getPrice());

                    Product product = (Product) s.clone();
                    product.setPrice(product.getPrice() + ((long)(product.getPrice() * 0.19)));
                    return product;
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
