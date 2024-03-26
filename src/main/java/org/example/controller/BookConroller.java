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
@CrossOrigin
public class BookConroller {

    final BookService bookService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> addBook(@RequestBody Book book) {
        BookEntity bookEntity = bookService.addBook(book);
        return  ResponseEntity.ok(bookEntity);
    }


    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> getAllBooks() {
        List<BookEntity> books = bookService.getBooks();
        return   ResponseEntity.ok(books);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable("id") Long id) {
        return bookService.deleteBook(id);

    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> getBookById(@PathVariable("id") Long id)  {
        return bookService.searchBook(id);


    }
    @PutMapping("/update")
    public ResponseEntity<?> updateBook(@RequestBody Book book){
        BookEntity updatedBook = bookService.updateBook(book);
        return ResponseEntity.status(HttpStatus.OK).body(updatedBook);
    }


}
