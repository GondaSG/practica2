package com.client.service;
import com.client.model.Client;
import java.util.List;

public interface ClientService {

    List<Client> findAll();
    Client findById(long id);
    Client create(Client client);
    Client update(Client client);
    void delete(long id);

}
