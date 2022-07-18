package com.book.controller;
import com.book.exception.ModelNotFoundException;
import com.book.model.Book;
import com.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "book")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> findAll() {
        return ResponseEntity.ok(bookService.findAll());
    }

    @PostMapping
    public ResponseEntity<Book> create(@Valid @RequestBody Book book) {
        Book response = bookService.create(book);
        //log.info("Request registered successfully.");
        return new ResponseEntity<Book>(response, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Book> update(@Valid @RequestBody Book book) {

        Book bookExists = bookService.findById(book.getId());
        if (bookExists.getId() == 0) {
            throw new ModelNotFoundException("ID not found.");
        }

        Book response = bookService.update(book);
        //  log.info("Request updated successfully.");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable("id") long id) {
        Book book = bookService.findById(id);
        if (book.getId() == 0) {
            throw new ModelNotFoundException("ID not found.");
        }
        return ResponseEntity.ok(book);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") long id) {
        Book book = bookService.findById(id);
        if (book.getId() == 0) {
            throw new ModelNotFoundException("ID not found.");
        }
        bookService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}