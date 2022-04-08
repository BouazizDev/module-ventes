package tn.codynet.moduleventes.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Article extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String reference;
    private String nom;
    private String Description;
    private int quantite;
    private String image;
    private double prix;
    private double prixUnitaireHT;
    private double prixDeVente;
    private double prixUnitaireTTC;
    @CreationTimestamp
    @Column(name = "created_at", updatable = false, nullable = false)
    protected Instant createdAt;
    @UpdateTimestamp
    @Column(name = "modified_at")
    protected Instant modifiedAt;
    //TAXE
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "product_tax",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "tax_id"))
    private List<Taxe> taxes;
    //CATEGORIE
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idCategorie")
    private Categorie categorie;
}
