package tn.codynet.moduleventes.services;

import tn.codynet.moduleventes.services.entities.Client;
import tn.codynet.moduleventes.services.entities.Entreprise;

import java.util.List;
import java.util.Optional;

public interface IEntrepriseService {
    Entreprise addEntreprise(Entreprise entreprise);
    Optional<Entreprise> findEntrepriseById(long id);
    void deleteEntreprise(long id);
}
