package tn.codynet.moduleventes.services.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Fournisseur extends AbstractEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name="reference")
    private String reference;
    @Column(name="nom")
    private String nom;
    @Column(name="prenom")
    private String prenom;
    @Column(name="numero")
    private int numero;
    @Column(name="email")
    private String email;
    @Embedded
    private Adresse adresse;
    @JsonBackReference
    @OneToMany
    private List<CommandeFournisseur> commandeFournisseurs;
    @CreationTimestamp
    @Column(name = "created_at", updatable = false, nullable = false)
    protected Instant createdAt;
    @UpdateTimestamp
    @Column(name = "modified_at")
    protected Instant modifiedAt;
}
