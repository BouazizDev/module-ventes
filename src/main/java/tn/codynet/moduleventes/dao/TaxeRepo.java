package tn.codynet.moduleventes.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.codynet.moduleventes.entities.Taxe;
@Repository
public interface TaxeRepo extends JpaRepository<Taxe,Long> {
}
