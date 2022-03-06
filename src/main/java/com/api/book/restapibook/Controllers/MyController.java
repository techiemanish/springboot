package com.api.book.restapibook.Controllers;

import java.util.List;
import java.util.Optional;

import com.api.book.restapibook.Entity.Book;
import com.api.book.restapibook.Services.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Book>> getBooks(){
        // Book book = new Book();
        // book.setId(1);
        // book.setAuthor("Manish Tiwari");
        // book.setTitle("Today is Monday");
        List<Book> result = bookService.getAllBook();
        if(result.size() <= 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(result));
    }

    //Search Book by Id
    @GetMapping("/books/{id}")
    public ResponseEntity<Book> bookById(@PathVariable("id") int id){
        Book book = bookService.getBookById(id);
        if(book == null){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(book));
    }

    //Post Method
    @PostMapping("/books")
    public ResponseEntity<Book> addBooks(@RequestBody Book bookObj){
        Book b = null;
        try {
            b =  this.bookService.addBook(bookObj);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //Delete Method
    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable("id") int id){
        try {
            this.bookService.deleteBookById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //Update Method
    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBookById(@RequestBody Book book, @PathVariable("id") int id){
        try {
            this.bookService.updateBook(book, id);
            return ResponseEntity.ok().body(book);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
