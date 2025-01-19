package com.jorge.springboot.factura.app.models;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Invoice {

    @Autowired
    private Client client;
    @Value("${invoice.description2}")
    private String description;
    @Autowired
    @Qualifier("listaDeItems2")
    private List<Item> items;

    @PostConstruct
    public void init() {
        this.client.setName(client.getName().concat(" Luis"));
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Destruyendo bean");
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getTotal() {
        return items.stream()
                .map(Item::getTotal)
                .reduce(0, (sum, total2) -> sum + total2);

//        List<Integer> list = items.stream()
//                .map(Item::getTotal)
//                .toList();
//        var total = 0;
//        for (Integer i : list) {
//            total += i;
//        }
//        return total;
//        var nuemroTotal = 0;
//        for (Item item : this.items) {
//            nuemroTotal += item.getTotal();
//        }
//        return nuemroTotal;
    }
}
