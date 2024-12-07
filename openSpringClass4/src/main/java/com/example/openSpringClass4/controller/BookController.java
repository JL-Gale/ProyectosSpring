package com.example.openSpringClass4.controller;

import com.example.openSpringClass4.entities.Book;
import com.example.openSpringClass4.repository.BookRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    // Buscar todos los libros (Lista de libros)
    @GetMapping("/api/books")
    public List<Book> findBookAl() {
        return bookRepository.findAll();
    }

    //buscar un solo libro en base de datos segun su id
    @GetMapping("/api/books/{id}")
    public Book findOneById(@PathVariable Long id) {

        Optional<Book> bookOpt = bookRepository.findById(id);

        if(bookOpt.isPresent())
            return bookOpt.get();
        else
            return null;

//        return bookOpt.orElse(null);

    }
}
