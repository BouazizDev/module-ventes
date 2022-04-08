package tn.codynet.moduleventes.services;


import tn.codynet.moduleventes.entities.Client;

import java.util.List;
import java.util.Optional;

public interface IClientService {
    Client addClient(Client client);
    List<Client> findAll();
    Optional<Client> findClientById(long id);
    Client findByRefrence(String ref);
    void deleteClient(long id);


}
