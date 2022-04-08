package tn.codynet.moduleventes.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.codynet.moduleventes.entities.LigneCommandeClient;
@Repository
public interface LigneCommandeClientRepo extends JpaRepository<LigneCommandeClient,Long> {
}
