package org.example.controller;

import org.example.dto.Book;
import org.example.entity.BookEntity;
import org.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookConroller {
    @Autowired
    BookService bookService;
    @PostMapping
    public BookEntity addBook(@RequestBody Book book){
       return bookService.addBook(book);
    }
}
