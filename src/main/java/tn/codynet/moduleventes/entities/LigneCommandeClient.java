package tn.codynet.moduleventes.entities;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper=false)
@Builder
public class LigneCommandeClient extends AbstractEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private BigDecimal quantite;
    private double prixUnitaire;
    @ManyToOne
    @JoinColumn(name = "idArticle")
    private Article article;

    @ManyToOne
    @JoinColumn(name="idCommande")
    private CommandeClient commandeClient;

    public BigDecimal calculerPrixTTC(){
        return quantite.multiply(BigDecimal.valueOf(article.getPrixUnitaireTTC()));
    }

}
