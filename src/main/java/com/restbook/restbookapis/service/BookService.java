package com.restbook.restbookapis.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
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

    public BookResponse removeBook(int id) {
        try {
            for (int i = 0; i < myList.size(); i++) {
                if (myList.get(i).getId() == id) {
                    myList.remove(i); // Remove the book at index i
                    return new BookResponse("Deleted Successfully", true);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new BookResponse("No Id Found", false);
    }

    public BookResponse updateBook(Book book, int bookId) {

        for (int i = 0; i < myList.size(); i++) {
            if (myList.get(i).getId() == bookId) {
                List<Book> list = myList.stream().map(b -> {
                    if (b.getId() == bookId) {
                        b.setName(book.getName());
                        b.setAuthor(book.getAuthor());
                    }
                    return b;
                }).collect(Collectors.toList());

                return new BookResponse("Record Updated", true);
            }
        }
        return new BookResponse("No Record Updated", false);
    }

}
