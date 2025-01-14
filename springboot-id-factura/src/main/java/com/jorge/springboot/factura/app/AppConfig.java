package com.jorge.springboot.factura.app;

import com.jorge.springboot.factura.app.models.Item;
import com.jorge.springboot.factura.app.models.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.List;

@Configuration
@PropertySource("classpath:data.properties")
public class AppConfig {

    @Bean
    public List<Item> listaDeItems(){
//        Product p1 = new Product("Glock 17", 1700);
//        Product p2 = new Product("Ar 15", 7500);
//        Product p3 = new Product("Revolver 38", 900);
//        Product p4 = new Product("Glock 19", 2100);
//        Item i1 = new Item(new Product("Glock 17", 1700), 2);
//        Item i2 = new Item(new Product("Ar 15", 7500), 1);
//        Item i3 = new Item(new Product("Revolver 38", 900), 1);
//        Item i4 = new Item(new Product("Revolver 38", 900), 2);
        return List.of(
                new Item(new Product("Glock 17", 1700), 2),
                new Item(new Product("Ar 15", 7500), 1),
                new Item(new Product("Revolver 38", 900), 1),
                new Item(new Product("Glock 19", 2100), 2));
    }
}
