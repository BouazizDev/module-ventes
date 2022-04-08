package tn.codynet.moduleventes.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.codynet.moduleventes.services.entities.CommandeFournisseur;

import java.util.Optional;

@Repository
public interface CommandeFournisseurRepo extends JpaRepository<CommandeFournisseur,Long> {
    Optional<CommandeFournisseur> findByReference(String ref);
}
