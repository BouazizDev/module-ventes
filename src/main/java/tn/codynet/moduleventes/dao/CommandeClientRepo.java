package tn.codynet.moduleventes.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.codynet.moduleventes.entities.CommandeClient;

import java.util.Optional;

@Repository
public interface CommandeClientRepo extends JpaRepository<CommandeClient,Long> {
    Optional<CommandeClient> findByReference(String ref);
}
