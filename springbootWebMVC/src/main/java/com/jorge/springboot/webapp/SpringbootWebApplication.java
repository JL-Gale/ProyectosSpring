package com.jorge.springboot.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//@PropertySource("classpath:values.properties")
//@PropertySource("values.properties")
//@PropertySources({@PropertySource("values.properties")})
public class SpringbootWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootWebApplication.class, args);
	}

}
