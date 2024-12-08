package com.example.openSpringClass4.controller;

import com.example.openSpringClass4.entities.Book;
import com.example.openSpringClass4.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BookController {

    private final Logger log = LoggerFactory.getLogger("BookController");
    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    // Buscar todos los libros (Lista de libros)
    @GetMapping("/books")
    public List<Book> findBookAl() {
        return bookRepository.findAll();
    }

    //buscar un solo libro en base de datos segun su id
    @GetMapping("/books/{id}")
    public ResponseEntity<Book> findOneById(@PathVariable Long id) {
        Optional<Book> bookOpt = bookRepository.findById(id);
        if(bookOpt.isPresent())
            return ResponseEntity.ok(bookOpt.get());
        else
            return ResponseEntity.notFound().build();
    }

    @PostMapping("/books")
    public ResponseEntity<Book> create(@RequestBody Book book) {
        if (book.getId() != null) {
            log.warn("trying to create a book with id");
            System.out.println("trying to create a book with id");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(bookRepository.save(book));
    }

    //Actualizar un libro existente
    @PutMapping("/books")
    public ResponseEntity<Book> update(@RequestBody Book book) {
        if (book.getId() == null) {
            log.warn("trying to update a not existent book");
            return ResponseEntity.badRequest().build();
        }
        if(!bookRepository.existsById(book.getId())) {
            log.warn("trying to update a not existent book");
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(bookRepository.save(book));
    }

    //Borrar un libro
    @DeleteMapping("/books")
    public ResponseEntity<Book> delete(@RequestBody Book book) {
        if (book.getId() == null) {
            log.warn("trying to delate a not existent book");
            return ResponseEntity.badRequest().build();
        }
        if(!bookRepository.existsById(book.getId())) {
            log.warn("trying to update a not existent book");
            return ResponseEntity.notFound().build();
        }
        bookRepository.deleteById(book.getId());
        return ResponseEntity.ok().build();
    }

    //Borrar todos los libros

}
