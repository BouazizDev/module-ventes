package tn.codynet.moduleventes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.codynet.moduleventes.entities.Categorie;
import tn.codynet.moduleventes.services.impl.CategorieServiceImpl;

import java.util.List;
import java.util.Optional;

@RestController
public class CategorieController {
    @Autowired
    private CategorieServiceImpl categorieService;
    @PostMapping(path = "categorie/add")
    Categorie addCategorie(@RequestBody Categorie categorie){
        return categorieService.addCategorie(categorie);
    };
    @GetMapping(path = "/categories")
    List<Categorie> findAll(){
        return categorieService.findAll();
    };
    @GetMapping(path = "/categorie/{id}")
    Optional<Categorie> findCategorieById(@PathVariable long id){
        return categorieService.findCategorieById(id);
    };
    @DeleteMapping(path = "/categorie/{id}")
    void deleteCategorie(long id){
        categorieService.deleteCategorie(id);
    };
}
