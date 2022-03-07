package com.api.book.restapibook.dao;

import com.api.book.restapibook.Entity.Book;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Integer>{
    
    public Book findById(int id);
}
