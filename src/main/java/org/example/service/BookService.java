package org.example.service;

import org.example.dto.Book;
import org.example.entity.BookEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface BookService {
    public BookEntity addBook(Book book);
    public List<BookEntity> getBooks();
    public ResponseEntity<?> deleteBook(Long id);
    public ResponseEntity<?> searchBook(Long id);
    public BookEntity updateBook(Book book);
}
