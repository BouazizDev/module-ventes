package tn.codynet.moduleventes.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.codynet.moduleventes.services.entities.CommandeClient;
import tn.codynet.moduleventes.services.entities.EtatCommande;
import tn.codynet.moduleventes.services.impl.CommandeClientServiceImpl;

import java.util.List;
import java.util.Optional;

@RestController
public class CommandeClientController {
    @Autowired
    private CommandeClientServiceImpl commandeClientService;
    @PostMapping("/commandeClient/add")
    CommandeClient addCommandeClient(@RequestBody CommandeClient commandeClient){
        return commandeClientService.addCommandeClient(commandeClient);
    };
    @GetMapping(path = "/commandeClients")
    List<CommandeClient> findAll(){
        return commandeClientService.findAll();
    };
    @GetMapping(path = "/commandeClient/{id}")
    Optional<CommandeClient> findCommandeClientById(@PathVariable long id){
        return commandeClientService.findCommandeClientById(id);
    };
    @GetMapping(path = "/commandeClient/{ref}")
    Optional<CommandeClient> findByReference(@PathVariable String ref){
        return commandeClientService.findByReference(ref);
    };
    @DeleteMapping(path = "commandeClient/{id}")
    void deleteCommandeClient(long id){
         commandeClientService.deleteCommandeClient(id);
    };
    @PatchMapping(path="/commandeClient/{id}/{etatCommande}")
    CommandeClient updateEtat(@PathVariable("id") long id,@PathVariable("etatCommande") EtatCommande etatCommande){
        return commandeClientService.updateEtat(id,etatCommande);
    };
}
