package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.Book;
import org.example.entity.BookEntity;
import org.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookConroller {

   final BookService bookService;
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public BookEntity addBook(@RequestBody Book book){
       return bookService.addBook(book);
    }


    @GetMapping("/all")
    public List<BookEntity> getAllBooks(){
      return bookService.getBooks();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id){
        if( bookService.deleteBook(id)){
           return "Deleted";
        }
      return  "Not Deleted";
    }
}
