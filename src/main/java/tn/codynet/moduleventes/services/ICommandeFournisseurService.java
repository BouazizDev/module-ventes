package tn.codynet.moduleventes.services;


import tn.codynet.moduleventes.entities.CommandeClient;
import tn.codynet.moduleventes.entities.CommandeFournisseur;
import tn.codynet.moduleventes.entities.EtatCommande;

import java.util.List;
import java.util.Optional;

public interface ICommandeFournisseurService {
    CommandeFournisseur addCommandeFournisseur(CommandeFournisseur article);
    List<CommandeFournisseur> findAll();
    Optional<CommandeFournisseur> findCommandeFournisseurById(long id);

    CommandeFournisseur updateEtat(long id, EtatCommande etatCommande);

    Optional<CommandeFournisseur> findByReference(String ref);
    void deleteCommandeFournisseur(long id);
}
