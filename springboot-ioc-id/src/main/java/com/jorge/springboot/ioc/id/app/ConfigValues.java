package com.jorge.springboot.ioc.id.app;

import com.jorge.springboot.ioc.id.app.repositories.ProductRepositoryImplJson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:values.properties")
public class ConfigValues {

    @Bean
    public ProductRepositoryImplJson productRepositoryImplJson() {
        return new ProductRepositoryImplJson();
    }

}
