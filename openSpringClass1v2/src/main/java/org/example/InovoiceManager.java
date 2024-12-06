package org.example;

import org.springframework.stereotype.Component;

@Component
public class InovoiceManager {
    CalculatorService calculatorService;
    public InovoiceManager (CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
        System.out.println("Constructor de factura");
    }


}
