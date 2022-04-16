package tn.codynet.moduleventes.services;

import tn.codynet.moduleventes.entities.EtatFacture;
import tn.codynet.moduleventes.entities.FactureFournisseur;

import java.util.List;
import java.util.Optional;

public interface IFactureFournisseurService {
    FactureFournisseur addFactureFournisseur(FactureFournisseur factureFournisseur);
    List<FactureFournisseur> findAll();
    Optional<FactureFournisseur> findFactureFournisseurById(long id);
    Optional<FactureFournisseur> findByReference(String ref);
    void deleteFactureFournisseur(long id);
    FactureFournisseur updateEtat(long id, EtatFacture etatFacture);
}
