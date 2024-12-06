package com.example.openSpringClass4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class OpenSpringClass4Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OpenSpringClass4Application.class, args);
		BookRepository bookRepository = context.getBean(BookRepository.class);
		bookRepository.save(new Book(null, "Las milgroserias", "Desconocido", LocalDate.now(), 100, (double) 120, true));
		System.out.println(bookRepository.count());

	}
}
