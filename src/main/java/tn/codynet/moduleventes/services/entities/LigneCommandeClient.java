package tn.codynet.moduleventes.services.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class LigneCommandeClient extends AbstractEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int quantite;
    private double prixUnitaire;
    @ManyToOne
    @JoinColumn(name = "idArticle")
    private Article article;

    @ManyToOne
    @JoinColumn(name="idCommande")
    private CommandeClient commandeClient;


}
