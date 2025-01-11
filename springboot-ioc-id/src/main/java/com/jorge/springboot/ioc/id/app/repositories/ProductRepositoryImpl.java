package com.jorge.springboot.ioc.id.app.repositories;

import com.jorge.springboot.ioc.id.app.models.Product;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.RequestScope;

import java.util.Arrays;
import java.util.List;

@Repository
@RequestScope
public class ProductRepositoryImpl implements IProductRepository{

    private List<Product> data;

    public ProductRepositoryImpl() {
        this.data = Arrays.asList(
                new Product(1l, "Arroz", 3500l),
                new Product(2l, "Caffe", 1000l),
                new Product(3l, "Panela", 2000l),
                new Product(4l, "Huevos", 900l),
                new Product(5l, "Platanos", 700l)
        );
    }

    @Override
    public List<Product> findAll() {
        return data;
    }

    @Override
    public Product findById(Long id) {
        /* .findFirst() (Obtener uno solo)-> Devuelve un Optional
        del tipo producto para saber si esta presente o null se
        usa para evitar un NullPointrExepcion.

        .get() -> Se obtiene el objeto en ves de un stream

        .orElseThrow() -> Se optiene el objeto en ves de un
        stream y puede devulver una exepcionNoSuchElementException
        en caso de que no se encuentre

        .orElse(null) ->
        */

//      return data.stream().filter(s -> s.getId().equals(id)).findFirst().get();
//      return data.stream().filter(s -> s.getId().equals(id)).findFirst().orElseThrow();
        return data.stream().filter(s -> s.getId().equals(id)).findFirst().orElse(null);
    }

}
