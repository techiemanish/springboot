package com.api.book.restapibook.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Author {
    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String author_name;
    private String author_language;

    @OneToOne(mappedBy = "author")
    @JsonBackReference
    private Book book;
    
    public Book getBook() {
        return book;
    }
    public void setBook(Book book) {
        this.book = book;
    }
    public Author(int id, String author_name, String author_language) {
        this.id = id;
        this.author_name = author_name;
        this.author_language = author_language;
    }
    public Author() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getAuthor_name() {
        return author_name;
    }
    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }
    public String getAuthor_language() {
        return author_language;
    }
    public void setAuthor_language(String author_language) {
        this.author_language = author_language;
    }
}
