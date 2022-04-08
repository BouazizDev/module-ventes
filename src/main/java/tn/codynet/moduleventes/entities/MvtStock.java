package tn.codynet.moduleventes.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.Instant;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class MvtStock extends AbstractEntity{
    private Instant dateMvt;
    private BigDecimal quantite;
    @ManyToOne
    @JoinColumn(name = "idArticle")
    private Article article;
    private TypeMvtStock typeMvtStock;
}
