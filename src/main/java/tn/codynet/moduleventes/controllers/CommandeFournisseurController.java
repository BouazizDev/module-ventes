package tn.codynet.moduleventes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.codynet.moduleventes.entities.CommandeFournisseur;
import tn.codynet.moduleventes.entities.EtatCommande;
import tn.codynet.moduleventes.services.impl.CommandeFournisseurImpl;

import java.util.List;
import java.util.Optional;

public class CommandeFournisseurController {
    @Autowired
    private CommandeFournisseurImpl commandeFournisseurService;

    @PostMapping("/commandeFournisseur/add")
    ResponseEntity<CommandeFournisseur> addCommandeFournisseur(@RequestBody CommandeFournisseur commandeFournisseur) {
        return ResponseEntity.ok(commandeFournisseurService.addCommandeFournisseur(commandeFournisseur));
    }

    ;

    @GetMapping(path = "/commandeFournisseurs")
    ResponseEntity<List<CommandeFournisseur>> findAll() {
        return ResponseEntity.ok(commandeFournisseurService.findAll());
    }

    ;

    @GetMapping(path = "/commandeFournisseur/{id}")
    ResponseEntity<Optional<CommandeFournisseur>> findCommandeFournisseurById(@PathVariable long id) {
        return ResponseEntity.ok(commandeFournisseurService.findCommandeFournisseurById(id));
    }

    ;

    @GetMapping(path = "/commandeFournisseur/{ref}")
    ResponseEntity<Optional<CommandeFournisseur>> findByReference(@PathVariable String ref) {
        return ResponseEntity.ok(commandeFournisseurService.findByReference(ref));
    }

    ;

    @DeleteMapping(path = "commandeFournisseur/{id}")
    ResponseEntity<CommandeFournisseur> deleteCommandeFournisseur(long id) {
        commandeFournisseurService.deleteCommandeFournisseur(id);

        return (ResponseEntity) ResponseEntity.ok();
    }

    ;

    @PatchMapping(path = "/commandeFournisseur/{id}/{etatCommande}")
    ResponseEntity<CommandeFournisseur> updateEtat(@PathVariable("id") long id, @PathVariable("etatCommande") EtatCommande etatCommande) {
        return ResponseEntity.ok(commandeFournisseurService.updateEtat(id, etatCommande));
    }
}
