package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.Book;
import org.example.entity.BookEntity;
import org.example.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookConroller {

    final BookService bookService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<BookEntity> addBook(@RequestBody Book book) {
        BookEntity bookEntity = bookService.addBook(book);
        return new ResponseEntity<>(bookEntity,HttpStatus.OK);
    }


    @GetMapping("/all")
    public ResponseEntity<List<BookEntity>> getAllBooks() {
        List<BookEntity> books = bookService.getBooks();
        return  new ResponseEntity<>(books,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable("id") Long id) {
        return bookService.deleteBook(id) ? new ResponseEntity<>("Deleted", HttpStatus.OK) :
                new ResponseEntity<>("Not Deleted", HttpStatus.NOT_FOUND);

    }

    @GetMapping("/search/{id}")
    public ResponseEntity<BookEntity> getBookById(@PathVariable("id") Long id)  {
        return bookService.searchBook(id) != null ? new ResponseEntity<>(bookService.searchBook(id), HttpStatus.OK) :
                new ResponseEntity<>( HttpStatus.NOT_FOUND);


    }


}
