package tn.codynet.moduleventes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.codynet.moduleventes.entities.CommandeClient;
import tn.codynet.moduleventes.entities.EtatCommande;
import tn.codynet.moduleventes.services.impl.CommandeClientServiceImpl;

import java.util.List;
import java.util.Optional;

@RestController
public class CommandeClientController {
    @Autowired
    private CommandeClientServiceImpl commandeClientService;

    @PostMapping("/commandeClient/add")
    ResponseEntity<CommandeClient> addCommandeClient(@RequestBody CommandeClient commandeClient) {
        return ResponseEntity.ok(commandeClientService.addCommandeClient(commandeClient));
    }

    ;

    @GetMapping(path = "/commandeClients")
    ResponseEntity<List<CommandeClient>> findAll() {
        return ResponseEntity.ok(commandeClientService.findAll());
    }

    ;

    @GetMapping(path = "/commandeClient/{id}")
    ResponseEntity<Optional<CommandeClient>> findCommandeClientById(@PathVariable long id) {
        return ResponseEntity.ok(commandeClientService.findCommandeClientById(id));
    }

    ;

    @GetMapping(path = "/commandeClient/{ref}")
    ResponseEntity<Optional<CommandeClient>> findByReference(@PathVariable String ref) {
        return ResponseEntity.ok(commandeClientService.findByReference(ref));
    }

    ;

    @DeleteMapping(path = "commandeClient/{id}")
     ResponseEntity<CommandeClient> deleteCommandeClient(long id) {
        commandeClientService.deleteCommandeClient(id);

        return (ResponseEntity) ResponseEntity.ok();
    }

    ;

    @PatchMapping(path = "/commandeClient/{id}/{etatCommande}")
    ResponseEntity<CommandeClient> updateEtat(@PathVariable("id") long id, @PathVariable("etatCommande") EtatCommande etatCommande) {
        return ResponseEntity.ok(commandeClientService.updateEtat(id, etatCommande));
    }


}
