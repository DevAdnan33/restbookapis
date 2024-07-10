package com.restbook.restbookapis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restbook.restbookapis.dao.BookRep;
import com.restbook.restbookapis.entities.Book;
import com.restbook.restbookapis.entities.BookResponse;

@Service
public class BookService {

    @Autowired
    private BookRep bookRep;

    public List<Book> getAllBooks() {
        List<Book> list = (List<Book>) bookRep.findAll();
        return list;
    }

    public Book getBook(int id) {
        Book book = null;
        try {
            // book = myList.stream().filter(e -> e.getId() == id).findFirst().get();
            book = bookRep.findById(id);
        } catch (Exception e) {
            e.getMessage();
        }

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
        // myList.add(new Book(book.getId(), book.getName(), book.getAuthor()));
        bookRep.save(book);
        return new BookResponse("Added Successfully");
    }

    public BookResponse removeBook(int id) {
        try {
            // for (int i = 0; i < myList.size(); i++) {
            //     if (myList.get(i).getId() == id) {
            //         myList.remove(i); // Remove the book at index i
            //         return new BookResponse("Deleted Successfully", true);
            //     }
            // }

            bookRep.deleteById(id);

        } catch (Exception e) {
            e.getMessage();
        }
        return new BookResponse("No Id Found");
    }

    public BookResponse updateBook(Book book, int bookId) {

        // for (int i = 0; i < myList.size(); i++) {
        //     if (myList.get(i).getId() == bookId) {
        //         List<Book> list = myList.stream().map(b -> {
        //             if (b.getId() == bookId) {
        //                 b.setName(book.getName());
        //                 b.setAuthor(book.getAuthor());
        //             }
        //             return b;
        //         }).collect(Collectors.toList());

        //         return new BookResponse("Record Updated", true);
        //     }
        // }

        book.setId(bookId);
        bookRep.save(book);
        return new BookResponse("No Record Updated");
    }

}
