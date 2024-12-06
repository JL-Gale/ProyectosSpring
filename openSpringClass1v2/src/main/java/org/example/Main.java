package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        CalculatorService calculatorService = (CalculatorService) context.getBean("calculatorService");
        InovoiceManager inovoiceManager = (InovoiceManager) context.getBean("inovoiceManager");
    }
}