package tn.codynet.moduleventes.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.codynet.moduleventes.services.entities.Client;
@Repository
public interface ClientRepo extends JpaRepository<Client,Long> {
    Client findByReference(String ref);
}
