package com.jorge.springboot.factura.app.controllers;


import com.jorge.springboot.factura.app.models.Invoice;
import com.jorge.springboot.factura.app.models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/")
public class InvoiceController {

    @Autowired
    Invoice invoice;

    @GetMapping("invoice")
    public Invoice factura(){
        return this.invoice;
    }

//    @GetMapping("total")
//    public Map<String, Object> facturaTotal() {
//        Map<String, Object> body = new HashMap<>();
//        body.put("Factura", invoice);
//        body.put("Total", total());
//        return body;
//    }
//
//    private int total() {
//        List<Item> items = invoice.getItems();
//        int valorTotal = 0;
//        for (Item item : items) {
//            var valorProducto = item.getProduct().getPrice();
//            valorProducto *= item.getQuantity();
//            valorTotal += valorProducto;
//        }
//        return valorTotal;
//    }
}
