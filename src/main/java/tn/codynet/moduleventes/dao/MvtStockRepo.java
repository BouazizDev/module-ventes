package tn.codynet.moduleventes.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.codynet.moduleventes.services.entities.MvtStock;
@Repository
public interface MvtStockRepo extends JpaRepository<MvtStock,Long> {
}
