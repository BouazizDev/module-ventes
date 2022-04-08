package tn.codynet.moduleventes.services.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class CommandeClient extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String reference;
    private EtatCommande etatCommande;
    @CreationTimestamp
    @Column(name = "created_at", updatable = false, nullable = false)
    protected Instant createdAt;
    @ManyToOne
    @JoinColumn(name = "idClient")
    private Client client;
    @OneToMany
    @JoinColumn(name = "commandeClient")
    @JsonIgnore
    private List<LigneCommandeClient> ligneCommandeClients;

    // check if commande livree
    public boolean isCommandeLivree(){
        return EtatCommande.LIVREE.equals(this.etatCommande);
    }

}
