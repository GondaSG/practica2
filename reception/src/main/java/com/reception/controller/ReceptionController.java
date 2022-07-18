package com.reception.controller;

import com.reception.exception.ModelNotFoundException;
import com.reception.model.Reception;
import com.reception.service.ReceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "reception")
public class ReceptionController {

    @Autowired
    ReceptionService receptionService;

    @GetMapping
    public ResponseEntity<List<Reception>> findAll() {
        return ResponseEntity.ok(receptionService.findAll());
    }

    @PostMapping
    public ResponseEntity<Reception> create(@Valid @RequestBody Reception reception) {
        Reception response = receptionService.create(reception);
        //log.info("Request registered successfully.");
        return new ResponseEntity<Reception>(response, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Reception> update(@Valid @RequestBody Reception reception) {

        Reception receptionExists = receptionService.findById(reception.getId());
        if (receptionExists.getId() == 0) {
            throw new ModelNotFoundException("ID not found.");
        }
        Reception response = receptionService.update(reception);

        //  log.info("Request updated successfully.");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reception> findById(@PathVariable("id") long id) {
        Reception reception = receptionService.findById(id);
        if (reception.getId() == 0) {
            throw new ModelNotFoundException("ID not found.");
        }
        return ResponseEntity.ok(reception);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") long id) {
        Reception reception = receptionService.findById(id);
        if (reception.getId() == 0) {
            throw new ModelNotFoundException("ID not found.");
        }
        receptionService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}