package com.example.openSpringClass4.repository;

import com.example.openSpringClass4.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
