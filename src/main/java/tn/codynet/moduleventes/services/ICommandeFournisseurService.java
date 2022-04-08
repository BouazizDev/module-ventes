package tn.codynet.moduleventes.services;


import tn.codynet.moduleventes.services.entities.CommandeFournisseur;

import java.util.List;
import java.util.Optional;

public interface ICommandeFournisseurService {
    CommandeFournisseur addCommandeFournisseur(CommandeFournisseur article);
    List<CommandeFournisseur> findAll();
    Optional<CommandeFournisseur> findCommandeFournisseurById(long id);
    Optional<CommandeFournisseur> findByReference(String ref);
    void deleteCommandeFournisseur(long id);
}
