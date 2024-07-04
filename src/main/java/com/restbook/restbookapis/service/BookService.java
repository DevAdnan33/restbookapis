package com.restbook.restbookapis.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.restbook.restbookapis.entities.Book;

@Service
public class BookService {

    List<Book> myList = Arrays.asList(
            new Book(1, "Powerful Mind", "Adnan"),
            new Book(2, "Rich Dad Poor Dad", "Richard"),
            new Book(3, "Alchemist", "Paulo Coheleo"));

    public List<Book> getAllBooks() {
        return myList;
    }

    public Book getBook(int id) {
        Book book = myList.stream().filter(e -> e.getId() == id).findFirst().get();

        /*
         * for (Book book : myList) {
         * if (book.getId() == id) {
         * return book;
         * }
         * }
         */

        return book;
    }

}
