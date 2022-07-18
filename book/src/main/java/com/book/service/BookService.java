package com.book.service;

import com.book.model.Book;
import java.util.List;

public interface BookService {

    List<Book> findAll();
    Book findById(long id);
    Book create(Book book);
    Book update(Book book);
    void delete(long id);

    void deleteById(long id);

    Book save(Book book);
}
