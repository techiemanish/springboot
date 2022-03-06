package com.api.book.restapibook.Controllers;

import java.util.List;

import com.api.book.restapibook.Entity.Book;
import com.api.book.restapibook.Services.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    //Search Book by Id
    @GetMapping("/books/{id}")
    public Book bookById(@PathVariable("id") int id){
        Book book = this.bookService.getBookById(id);
        return book;
    }

    //Post Method
    @PostMapping("/books")
    public Book addBooks(@RequestBody Book bookObj){
        Book b = this.bookService.addBook(bookObj);
        return b;
    }

    //Delete Method
    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable("id") int id){
        this.bookService.deleteBookById(id);
    }

    //Update Method
    @PutMapping("/books/{id}")
    public Book updateBookById(@RequestBody Book book, @PathVariable("id") int id){
        this.bookService.updateBook(book, id);
        return book;
    }
}
