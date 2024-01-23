package org.example.service;

import org.example.dto.Book;
import org.example.entity.BookEntity;

import java.util.List;

public interface BookService {
    public BookEntity addBook(Book book);
    public List<BookEntity> getBooks();
}
