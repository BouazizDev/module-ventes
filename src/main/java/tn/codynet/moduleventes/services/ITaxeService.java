package tn.codynet.moduleventes.services;

import tn.codynet.moduleventes.entities.Taxe;

import java.util.List;
import java.util.Optional;

public interface ITaxeService {
    Taxe addTaxe(Taxe taxe);
    List<Taxe> findAll();
    Optional<Taxe> findTaxeById(long id);
    void deleteTaxe(long id);
}
