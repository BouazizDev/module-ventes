package tn.codynet.moduleventes.services;

import tn.codynet.moduleventes.entities.Entreprise;

import java.util.Optional;

public interface IEntrepriseService {
    Entreprise addEntreprise(Entreprise entreprise);
    Optional<Entreprise> findEntrepriseById(long id);
    void deleteEntreprise(long id);
}
