package tn.codynet.moduleventes.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.codynet.moduleventes.entities.MvtStock;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface MvtStockRepo extends JpaRepository<MvtStock,Long> {
    @Query("select sum(m.quantite) from MvtStock m where m.article.id = :idArticle")
    BigDecimal realTimeStock(@Param("idArticle")long idArticle);

    List<MvtStock> findAllByArticleId(long idArticle);
}
