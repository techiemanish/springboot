package com.api.book.restapibook.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.api.book.restapibook.Entity.Book;
import com.api.book.restapibook.dao.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    
    // private static List<Book> data = new ArrayList<Book>();

    // static{
    //     data.add(new Book(1,"Java: Fundamental", "abc"));
    //     data.add(new Book(2,"Python", "bcd"));
    //     data.add(new Book(3,"Spring", "cde"));
    //     data.add(new Book(4,"MySQL", "def"));
    //     data.add(new Book(5,"JavaScript", "efg"));
    // }

    public List<Book> getAllBook(){
        List<Book> data = (List<Book>) bookRepository.findAll();
        return data;
    }

    
    public Book getBookById(int id){
        Book book = null;
        try{
            // book = data.stream().filter(e->e.getId()==id).findFirst().get();
            book = bookRepository.findById(id);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return book;
    }

    //Post Method
    public Book addBook(Book b){
        // data.add(b);
        Book result = bookRepository.save(b);
        return result;
    }

    //Delete Method 
    public void deleteBookById(int id){
        // data = data.stream().filter(e->e.getId()!=id).collect(Collectors.toList());
        bookRepository.deleteById(id);
    }

    //Update Method
    public void updateBook(Book book, int id){
        // Book res = data.stream().filter(e->e.getId() == id).findFirst().get();
        // res = book;
        // data = data.stream().map(e->{
        //     if(e.getId() == id){
        //         e.setTitle(book.getTitle());
        //         e.setAuthor(book.getAuthor());
        //     }
        //     return e;
        // }).collect(Collectors.toList());
        book.setId(id);
        bookRepository.save(book);
    }
}
