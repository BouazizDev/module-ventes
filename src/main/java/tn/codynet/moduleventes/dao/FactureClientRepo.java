package tn.codynet.moduleventes.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.codynet.moduleventes.entities.FactureClient;

import java.util.Optional;

@Repository
public interface FactureClientRepo extends JpaRepository<FactureClient,Long> {
    Optional<FactureClient> findByRefrence(String ref);

}
