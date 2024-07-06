package com.restbook.restbookapis.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PostExchange;

import com.restbook.restbookapis.entities.Book;
import com.restbook.restbookapis.entities.BookResponse;
import com.restbook.restbookapis.service.BookService;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable("id") int id) {
        return bookService.getBook(id);
    }

    @PostExchange("/books")
    public BookResponse addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }
}
