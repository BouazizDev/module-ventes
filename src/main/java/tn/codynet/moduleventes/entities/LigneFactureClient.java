package tn.codynet.moduleventes.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LigneFactureClient extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "facture_id")
    private FactureClient factureClient;

    @ManyToOne
    @JoinColumn(name = "commmande_id")
    private CommandeClient commandeClient;

}
