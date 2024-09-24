package com.booksystem.controller;

import com.booksystem.model.Book;
import com.booksystem.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/books")
public class BookController {
    @Autowired
    private BookService bookService;
    @GetMapping
    public ResponseEntity<List<Book>>getAll() {
      List<Book> bookList = bookService.getAll();
      return new ResponseEntity<>(bookList, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Book> getById(@PathVariable("id") Long bookId) {
      Book book =  bookService.getById(bookId);
      return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Book> create(@RequestBody Book book) {
      Book savedBook = bookService.create(book);
      return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Book> update(@PathVariable("id") Long bookId,@RequestBody Book book) {
          book.setId(bookId);
          Book updatedBook =  bookService.update(book);
          return new ResponseEntity<>(updatedBook, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long bookId) {
        bookService.delete(bookId);
        return new ResponseEntity<>("Book was deleted successfully", HttpStatus.OK);
    }
}
