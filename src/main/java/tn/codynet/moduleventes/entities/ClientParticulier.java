package tn.codynet.moduleventes.entities;

import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Part")
@EqualsAndHashCode(callSuper = true)
public class ClientParticulier  extends Client{
    @Column(name="nom")
    private String nom;
    @Column(name="prenom")
    private String prenom;
}
