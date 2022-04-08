package tn.codynet.moduleventes.services.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Entreprise extends AbstractEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nom;
    private String photo;
    @Embedded
    private Adresse adresse;
    private String numero;
    private String email;
}
