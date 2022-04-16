package tn.codynet.moduleventes.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class FactureFournisseur extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String refrence;
    private EtatFacture etatFacture;

    @OneToMany(mappedBy = "facture",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonIgnore
    private List<LigneFactureClient> ligneFactureFournisseur;

    public boolean isFactureValide(){
        return EtatCommande.VALIDE.equals(this.etatFacture);
    }
}
