package tn.codynet.moduleventes.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.codynet.moduleventes.entities.ClientProfessionnelle;
@Repository
public interface ClientProfessionnelleRepo extends JpaRepository<ClientProfessionnelle,Long> {
}
