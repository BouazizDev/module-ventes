package tn.codynet.moduleventes.services;

import tn.codynet.moduleventes.entities.CommandeClient;
import tn.codynet.moduleventes.entities.EtatCommande;

import java.util.List;
import java.util.Optional;

public interface ICommandeClientService {
    CommandeClient addCommandeClient(CommandeClient commandeClient);
    List<CommandeClient> findAll();
    Optional<CommandeClient> findCommandeClientById(long id);
    Optional<CommandeClient> findByReference(String ref);
    void deleteCommandeClient(long id);
    CommandeClient updateEtat(long id, EtatCommande etatCommande);

}
