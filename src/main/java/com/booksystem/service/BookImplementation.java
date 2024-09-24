package com.booksystem.service;
import com.booksystem.model.Book;
import com.booksystem.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookImplementation implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book create(Book book) {
      return bookRepository.save(book);
    }

    @Override
    public Book getById(Long bookId) {
      Optional<Book> optionalBook = bookRepository.findById(bookId);
      return optionalBook.get();
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book update(Book book) {
      Book existingBook = bookRepository.findById(book.getId()).get();
      existingBook.setTitle(book.getTitle());
      existingBook.setAuthor(book.getAuthor());
      existingBook.setDescription(book.getDescription());
      existingBook.setCategory(book.getCategory());
      Book updatedBook = bookRepository.save(existingBook);
      return updatedBook;
    }

    @Override
    public void delete(Long bookId) {
       bookRepository.deleteById(bookId);
    }
}