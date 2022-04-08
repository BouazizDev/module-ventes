package tn.codynet.moduleventes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.codynet.moduleventes.entities.Fournisseur;
import tn.codynet.moduleventes.services.impl.FournisseurServiceImpl;

import java.util.List;
import java.util.Optional;
@RestController
public class FournisseurController {
    @Autowired
    private FournisseurServiceImpl fournisseurService;

    @PostMapping(path = "fournisseur/add")
    Fournisseur addFournisseur(@RequestBody Fournisseur fournisseur) {
        return fournisseurService.addFournisseur(fournisseur);
    }

    ;

    @GetMapping(path = "/fournisseurs")
    List<Fournisseur> findAll() {
        return fournisseurService.findAll();
    }

    ;

    @GetMapping(path = "/fournisseur/{id}")
    Optional<Fournisseur> findFournisseurById(@PathVariable long id) {
        return fournisseurService.findFournisseurById(id);
    }

    ;

    @GetMapping(path = "/fournisseur/{ref}")
    Fournisseur findByRefrence(@PathVariable String ref) {
        return fournisseurService.findByRefrence(ref);
    }

    ;

    @DeleteMapping(path = "/fournisseur/{id}")
    void deleteFournisseur(@PathVariable long id) {
        fournisseurService.deleteFournisseur(id);
    }

    ;
}
