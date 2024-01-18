package org.example.service;

import org.example.dto.Book;
import org.example.entity.BookEntity;

public interface BookService {
    public BookEntity addBook(Book book);
}
