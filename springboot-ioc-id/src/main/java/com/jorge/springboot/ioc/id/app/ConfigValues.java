package com.jorge.springboot.ioc.id.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:values.properties")
public class ConfigValues {
}
