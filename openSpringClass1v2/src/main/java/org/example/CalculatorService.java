package org.example;

import org.springframework.stereotype.Component;

@Component
public class CalculatorService {
    public CalculatorService() {
        System.out.println("Constuctor de calculadora");
    }
}
