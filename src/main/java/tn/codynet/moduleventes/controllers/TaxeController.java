package tn.codynet.moduleventes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.codynet.moduleventes.services.entities.Taxe;
import tn.codynet.moduleventes.services.impl.TaxeServiceImpl;

import java.util.List;
import java.util.Optional;

@RestController
public class TaxeController {
    @Autowired
    private TaxeServiceImpl taxeService;
    @PostMapping(path = "/taxe/add")
    Taxe addTaxe(@RequestBody Taxe taxe){
        return taxeService.addTaxe(taxe);
    };
    @GetMapping(path = "/taxes")
    List<Taxe> findAll(){
        return taxeService.findAll();
    };
    @GetMapping(path = "/taxe/{id}")
    Optional<Taxe> findTaxeById(@PathVariable long id){
        return taxeService.findTaxeById(id);
    };
    @DeleteMapping(path = "/taxe/{id}")
    void deleteTaxe(long id){
        taxeService.deleteTaxe(id);
    };
}
