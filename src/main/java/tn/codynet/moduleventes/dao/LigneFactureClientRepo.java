package tn.codynet.moduleventes.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.codynet.moduleventes.entities.LigneFactureClient;
@Repository
public interface LigneFactureClientRepo extends JpaRepository<LigneFactureClient,Long> {
}
