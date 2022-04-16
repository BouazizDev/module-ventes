package tn.codynet.moduleventes.services;

import tn.codynet.moduleventes.entities.FactureClient;
import tn.codynet.moduleventes.entities.EtatFacture;

import java.util.List;
import java.util.Optional;

public interface IFactureClientService {
    FactureClient addFactureClient(FactureClient factureClient);
    List<FactureClient> findAll();
    Optional<FactureClient> findFactureClientById(long id);
    Optional<FactureClient> findByReference(String ref);
    void deleteFactureClient(long id);
    FactureClient updateEtat(long id, EtatFacture etatFacture);
}
