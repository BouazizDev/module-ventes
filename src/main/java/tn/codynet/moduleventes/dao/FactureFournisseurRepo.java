package tn.codynet.moduleventes.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.codynet.moduleventes.entities.FactureClient;
import tn.codynet.moduleventes.entities.FactureFournisseur;

import java.util.Optional;

@Repository
public interface FactureFournisseurRepo extends JpaRepository<FactureFournisseur,Long> {
    Optional<FactureFournisseur> findByRefrence(String ref);

}
