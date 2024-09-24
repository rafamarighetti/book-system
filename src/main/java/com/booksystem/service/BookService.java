package com.booksystem.service;

import com.booksystem.model.Book;
import java.util.List;

public interface BookService {
    
    List<Book> getAll();

    Book getById(Long id);

    Book create(Book book);

    Book update(Book book);
    
    void delete(Long id);

}
