package tn.codynet.moduleventes.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.codynet.moduleventes.dao.ClientRepo;
import tn.codynet.moduleventes.entities.Client;
import tn.codynet.moduleventes.services.IClientService;

import java.util.List;
import java.util.Optional;
@Service
@Slf4j
public class ClientServiceImpl implements IClientService {
    @Autowired
    private ClientRepo clientRepo;
    @Override
    public Client addClient(Client client) {
        return clientRepo.save(client);
    }

    @Override
    public List<Client> findAll() {
        return clientRepo.findAll();
    }

    @Override
    public Optional<Client> findClientById(long id) {
        return clientRepo.findById(id);
    }

    @Override
    public Client findByRefrence(String ref) {
        return clientRepo.findByReference(ref);
    }

    @Override
    public void deleteClient(long id) {
        clientRepo.deleteById(id);
    }
}
