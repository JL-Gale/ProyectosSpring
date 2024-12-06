package org.example;

public class GestorFactura {

    CalculatorService calculatorService;
    String name;

    public GestorFactura(CalculatorService calculatorService, String name) {
        this.calculatorService = calculatorService;
        this.name = name;
        System.out.println("Condtructor de factura");
    }

    @Override
    public String toString() {
        return "GestorFactura{" +
                "calculatorService=" + calculatorService +
                ", name='" + name + '\'' +
                '}';
    }
}
