package tn.codynet.moduleventes.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.codynet.moduleventes.entities.Fournisseur;
@Repository
public interface FournisseurRepo extends JpaRepository<Fournisseur,Long> {
    Fournisseur findByReference(String ref);
}
