package com.example.openSpringClass4;

import com.example.openSpringClass4.controller.BookController;
import com.example.openSpringClass4.entities.Book;
import com.example.openSpringClass4.repository.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class OpenSpringClass4Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OpenSpringClass4Application.class, args);
		BookRepository bookRepository = context.getBean(BookRepository.class);
		BookController bookController = new BookController(bookRepository);
		bookController.create(new Book (null, "Las milgroserias", "Desconocido", LocalDate.now(), 100, 120D, true));
		System.out.println(bookRepository.count());
	}
}
