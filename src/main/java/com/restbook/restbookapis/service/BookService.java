package com.restbook.restbookapis.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.restbook.restbookapis.entities.Book;
import com.restbook.restbookapis.entities.BookResponse;

@Service
public class BookService {

    static List<Book> myList = new ArrayList<>();

    static {
        myList.add(new Book(1, "Powerful Mind", "Adnan"));
        myList.add(new Book(2, "Rich Dad Poor Dad", "Richard"));
        myList.add(new Book(3, "Alchemist", "Paulo Coheleo"));
    }

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

    public BookResponse addBook(Book book) {
        myList.add(new Book(book.getId(), book.getName(), book.getAuthor()));
        return new BookResponse("Added Successfully", true);
    }

}
