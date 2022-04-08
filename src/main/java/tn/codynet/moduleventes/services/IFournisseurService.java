package tn.codynet.moduleventes.services;

import tn.codynet.moduleventes.entities.Fournisseur;

import java.util.List;
import java.util.Optional;

public interface IFournisseurService {
    Fournisseur addFournisseur(Fournisseur fournisseur);
    List<Fournisseur> findAll();
    Optional<Fournisseur> findFournisseurById(long id);
    Fournisseur findByRefrence(String ref);
    void deleteFournisseur(long id);
}
