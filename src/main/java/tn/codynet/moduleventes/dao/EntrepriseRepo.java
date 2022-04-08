package tn.codynet.moduleventes.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.codynet.moduleventes.entities.Entreprise;

public interface EntrepriseRepo extends JpaRepository<Entreprise,Long> {
}
