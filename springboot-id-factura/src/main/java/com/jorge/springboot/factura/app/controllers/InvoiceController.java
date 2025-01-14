package com.jorge.springboot.factura.app.controllers;


import com.jorge.springboot.factura.app.models.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/")
public class InvoiceController {

    @Autowired
    Invoice invoice;

    @GetMapping("invoice")
    public Invoice factura(){
        return this.invoice;
    }
}
