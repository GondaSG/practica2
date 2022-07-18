package com.book.service.impl;
import com.book.model.Book;
import com.book.repository.BookRepository;
import com.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookService bookRepository;

    @Override
    public List<Book> findAll() {return bookRepository.findAll();
    }

    @Override
    public Book findById(long id) {
        Optional<Book> op = Optional.ofNullable(bookRepository.findById(id));
        return op.isPresent() ? op.get() : new Book();
    }

    @Override
    public Book create(Book book) {
        return bookRepository.save(book);
    }


    @Override
    public Book update(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void delete(long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public Book save(Book book) {
        return null;
    }
}
