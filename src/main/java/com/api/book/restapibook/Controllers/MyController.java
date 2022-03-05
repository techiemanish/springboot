package com.api.book.restapibook.Controllers;

import java.util.List;

import com.api.book.restapibook.Entity.Book;
import com.api.book.restapibook.Services.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
    private BookService bookService;
    
    // @RequestMapping(value = "/books", method = RequestMethod.GET)
    // @ResponseBody
    @GetMapping("/books")
    public List<Book> getBooks(){
        // Book book = new Book();
        // book.setId(1);
        // book.setAuthor("Manish Tiwari");
        // book.setTitle("Today is Monday");
        List<Book> result = bookService.getAllBook();
        return result;
    }

    // @GetMapping("/books/{id}")
    // public Book bookById(@PathVariable("id") int id){
    //     Book book = this.bookService.getBookById(id);
    //     return book;
    // }
}
