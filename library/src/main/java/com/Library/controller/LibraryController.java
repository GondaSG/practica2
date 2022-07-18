package com.Library.controller;
import com.Library.exception.ModelNotFoundException;
import com.Library.model.Library;
import com.Library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "Library")
public class LibraryController {

    @Autowired
    LibraryService libraryService;

    @GetMapping
    public ResponseEntity<List<Library>> findAll() {return ResponseEntity.ok(libraryService.findAll());
    }

    @PostMapping
    public ResponseEntity<Library> create(@Valid @RequestBody Library library) {
        Library response = libraryService.create(library);
        //log.info("Request registered successfully.");
        return new ResponseEntity<Library>(response, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Library> update(@Valid @RequestBody Library library) {

        Library libraryExists = libraryService.findById(library.getId());
        if (libraryExists.getId() == 0) {
            throw new ModelNotFoundException("ID not found.");
        }

        Library response = libraryService.update(library);
        //  log.info("Request updated successfully.");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Library> findById(@PathVariable("id") long id) {
        Library library = libraryService.findById(id);
        if (library.getId() == 0) {
            throw new ModelNotFoundException("ID not found.");
        }
        return ResponseEntity.ok(library);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") long id) {
        Library library = libraryService.findById(id);
        if (library.getId() == 0) {
            throw new ModelNotFoundException("ID not found.");
        }
        libraryService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}