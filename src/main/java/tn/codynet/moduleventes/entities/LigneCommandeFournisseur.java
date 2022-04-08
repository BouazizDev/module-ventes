package tn.codynet.moduleventes.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
public class LigneCommandeFournisseur extends AbstractEntity{
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
    private CommandeFournisseur commandeFournisseur;
}
