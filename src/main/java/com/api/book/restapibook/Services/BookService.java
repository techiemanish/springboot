package com.api.book.restapibook.Services;

import java.util.ArrayList;
import java.util.List;

import com.api.book.restapibook.Entity.Book;

import org.springframework.stereotype.Component;

@Component
public class BookService {
    
    private static List<Book> data = new ArrayList<Book>();

    static{
        data.add(new Book(1,"Java: Fundamental", "abc"));
        data.add(new Book(2,"Python", "bcd"));
        data.add(new Book(3,"Spring", "cde"));
        data.add(new Book(4,"MySQL", "def"));
        data.add(new Book(5,"JavaScript", "efg"));
    }

    public List<Book> getAllBook(){
        return data;
    }

    
    public Book getBookById(int id){
        Book book = null;
        book = data.stream().filter(e->e.getId()==id).findFirst().get();
        return book;
    }

    //Post Method
    public Book addBook(Book b){
        data.add(b);
        return b;
    }
}
