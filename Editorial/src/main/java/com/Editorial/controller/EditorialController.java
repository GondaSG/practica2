package com.Editorial.controller;
import com.Editorial.exception.ModelNotFoundException;
import com.Editorial.model.Editorial;
import com.Editorial.service.EditorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "editorial")
public class EditorialController {

    @Autowired
    EditorialService editorialService;

    @GetMapping
    public ResponseEntity<List<Editorial>> findAll() {
        return ResponseEntity.ok(editorialService.findAll());
    }

    @PostMapping
    public ResponseEntity<Editorial> create(@Valid @RequestBody Editorial editorial) {
        Editorial response = editorialService.create(editorial);
        //log.info("Request registered successfully.");
        return new ResponseEntity<Editorial>(response, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Editorial> update(@Valid @RequestBody Editorial editorial) {

        Editorial editorialExists = editorialService.findById(editorial.getId());
        if (editorialExists.getId() == 0) {
            throw new ModelNotFoundException("ID not found.");
        }

        Editorial response = editorialService.update(editorial);
        //  log.info("Request updated successfully.");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Editorial> findById(@PathVariable("id") long id) {
        Editorial editorial = editorialService.findById(id);
        if (editorial.getId() == 0) {
            throw new ModelNotFoundException("ID not found.");
        }
        return ResponseEntity.ok(editorial);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") long id) {
        Editorial editorial = editorialService.findById(id);
        if (editorial.getId() == 0) {
            throw new ModelNotFoundException("ID not found.");
        }
        editorialService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}