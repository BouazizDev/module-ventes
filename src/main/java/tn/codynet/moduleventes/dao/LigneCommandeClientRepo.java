package tn.codynet.moduleventes.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.codynet.moduleventes.entities.LigneCommandeClient;

import java.util.List;

@Repository
public interface LigneCommandeClientRepo extends JpaRepository<LigneCommandeClient,Long> {
    List<LigneCommandeClient> findAllByCommandeClientId(long idCommande);
}
