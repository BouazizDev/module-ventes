package tn.codynet.moduleventes.services;

import tn.codynet.moduleventes.entities.Categorie;

import java.util.List;
import java.util.Optional;

public interface ICategorieService {
    Categorie addCategorie(Categorie categorie);
    List<Categorie> findAll();
    Optional<Categorie> findCategorieById(long id);
    void deleteCategorie(long id);
}
