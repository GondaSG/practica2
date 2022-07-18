package com.client.service.impl;
import com.client.model.Client;
import com.client.repository.ClientRepository;
import com.client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public List<Client> findAll() {return clientRepository.findAll();
    }

    @Override
    public Client findById(long id) {
        Optional<Client> op = clientRepository.findById(id);
        return op.isPresent() ? op.get() : new Client();
    }

    @Override
    public Client create(Client client) {
        return clientRepository.save(client);
    }


    @Override
    public Client update(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public void delete(long id) {
        clientRepository.deleteById(id);
    }
}
