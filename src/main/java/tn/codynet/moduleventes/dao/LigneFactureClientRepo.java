package tn.codynet.moduleventes.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.codynet.moduleventes.entities.LigneFactureClient;

public interface LigneFactureClientRepo extends JpaRepository<LigneFactureClient,Long> {
}
