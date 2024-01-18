package org.example.service.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dto.Book;
import org.example.entity.BookEntity;
import org.example.repository.BookRepository;
import org.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    ObjectMapper objectMapper;
    public BookEntity addBook(Book book){
        BookEntity bookEntity = objectMapper.convertValue(book, BookEntity.class);
       return bookRepository.save(bookEntity);

    }
}
