package tn.codynet.moduleventes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.codynet.moduleventes.entities.Entreprise;
import tn.codynet.moduleventes.services.impl.EntrepriseServiceImpl;

import java.util.Optional;
@RestController
public class EntrepriseController {
    @Autowired
    private EntrepriseServiceImpl entrepriseService;
    @PostMapping(path = "/entreprise/add")
    ResponseEntity<Entreprise> addEntreprise(Entreprise entreprise){

        return ResponseEntity.ok(entrepriseService.addEntreprise(entreprise));
    };
    @GetMapping(path = "/entreprise/{id}")
    ResponseEntity<Optional<Entreprise>> findEntrepriseById(@PathVariable long id){
        return ResponseEntity.ok(entrepriseService.findEntrepriseById(id));
    };
    @DeleteMapping(path = "/entreprise/{id}")
    ResponseEntity deleteEntreprise(@PathVariable long id){
        entrepriseService.deleteEntreprise(id);
        return (ResponseEntity) ResponseEntity.ok();
    };
}
