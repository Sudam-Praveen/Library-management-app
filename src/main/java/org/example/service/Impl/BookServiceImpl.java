package org.example.service.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dto.Book;
import org.example.entity.BookEntity;
import org.example.repository.BookRepository;
import org.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    ObjectMapper objectMapper;

    public BookEntity addBook(Book book) {


        List<BookEntity> all = bookRepository.findAll();
        for (BookEntity theBook:all) {
            if(theBook.getTitle().equals(book.getTitle())){
                return null;
            }
        }
        BookEntity bookEntity = objectMapper.convertValue(book, BookEntity.class);
        return bookRepository.save(bookEntity);

    }

    @Override
    public List<BookEntity> getBooks() {
//        List<Book> list = new ArrayList<>();
//        Iterable<BookEntity> allBooks = bookRepository.findAll();
//        Iterator<BookEntity> iterator = allBooks.iterator();
//        while (iterator.hasNext()){
//            BookEntity nextBook = iterator.next();
//            Book book = objectMapper.convertValue(nextBook, Book.class);
//            list.add(book);
//
//        }
//        return list;
        return bookRepository.findAll();
    }

    @Override
    public boolean deleteBook(Long id) {
        Optional<BookEntity> book = bookRepository.findById(id);
        if (book.isPresent()) {
            bookRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public BookEntity searchBook(Long id) {
        Optional<BookEntity> book = bookRepository.findById(id);
        if (book.isPresent()) {
            BookEntity bookEntity = book.get();
            return bookEntity;
        } else {
            return null;
        }
    }

}
