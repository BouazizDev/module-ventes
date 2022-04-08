package tn.codynet.moduleventes.services.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper=false)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_client", discriminatorType = DiscriminatorType.STRING)

public class Client extends AbstractEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name="reference")
    private String reference;
    @Column(name="numero")
    private int numero;
    @Column(name="email")
    private String email;
    @Embedded
    private Adresse adresse;
    @CreationTimestamp
    @Column(name = "created_at", updatable = false, nullable = false)
    protected Instant createdAt;
    @UpdateTimestamp
    @Column(name = "modified_at")
    protected Instant modifiedAt;

    //COMMANDE CLIENT
    @JsonBackReference
    @OneToMany
    private List<CommandeClient> commandeClients;

}
