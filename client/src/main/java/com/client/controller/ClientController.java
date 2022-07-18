package com.client.controller;
import com.client.exception.ModelNotFoundException;
import com.client.model.Client;
import com.client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping
    public ResponseEntity<List<Client>> findAll() {
        return ResponseEntity.ok(clientService.findAll());
    }

    @PostMapping
    public ResponseEntity<Client> create(@Valid @RequestBody Client cliente) {
        Client response = clientService.create(cliente);
        //log.info("Request registered successfully.");
        return new ResponseEntity<Client>(response, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Client> update(@Valid @RequestBody Client client) {

        Client clientExists = clientService.findById(client.getId());
        if (clientExists.getId() == 0) {
            throw new ModelNotFoundException("ID not found.");
        }

        Client response = clientService.update(client);
        //  log.info("Request updated successfully.");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> findById(@PathVariable("id") long id) {
        Client cliente = clientService.findById(id);
        if (cliente.getId() == 0) {
            throw new ModelNotFoundException("ID not found.");
        }
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") long id) {
        Client client = clientService.findById(id);
        if (client.getId() == 0) {
            throw new ModelNotFoundException("ID not found.");
        }
        clientService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}