package com.restbook.restbookapis.dao;

import org.springframework.data.repository.CrudRepository;

import com.restbook.restbookapis.entities.Book;

public interface BookRep extends CrudRepository<Book,Integer>{
    public Book findById(int id);
}
