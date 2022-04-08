package tn.codynet.moduleventes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.codynet.moduleventes.entities.Client;
import tn.codynet.moduleventes.services.impl.ClientServiceImpl;

import java.util.List;
import java.util.Optional;
@RestController
public class ClientController {
    @Autowired
    private ClientServiceImpl clientService;
    @PostMapping(path = "client/add")
    Client addClient(@RequestBody Client client){
        return clientService.addClient(client);
    };
    @GetMapping(path = "/clients")
    List<Client> findAll(){
        return clientService.findAll();
    };
    @GetMapping(path = "/client/{id}")
    Optional<Client> findClientById(@PathVariable long id){
        return clientService.findClientById(id);
    };
    @GetMapping(path = "/client/{ref}")
    Client findByRefrence(@PathVariable String ref){
        return  clientService.findByRefrence(ref);
    };
    @DeleteMapping(path = "/client/{id}")
    void deleteClient(long id){
        clientService.deleteClient(id);
    };
}
