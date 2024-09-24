package com.booksystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.booksystem.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
