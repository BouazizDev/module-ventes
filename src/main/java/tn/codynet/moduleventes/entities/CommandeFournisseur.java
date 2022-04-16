package tn.codynet.moduleventes.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommandeFournisseur extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String reference;
    private EtatCommande etatCommande;
    @CreationTimestamp
    @Column(name = "created_at", updatable = false, nullable = false)
    protected Instant createdAt;
    @ManyToOne
    @JoinColumn(name = "idFournisseur")
    private Fournisseur fournisseur;
    @OneToMany
    @JoinColumn(name = "commandeFournisseur")
    private List<LigneCommandeFournisseur> ligneCommandeFournisseurs;
    //check if commande is delivered
    public boolean isCommandeLivree(){
        return EtatCommande.LIVREE.equals(this.etatCommande);
    }
}
