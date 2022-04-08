package tn.codynet.moduleventes.services.entities;

import lombok.EqualsAndHashCode;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Pro")
@EqualsAndHashCode(callSuper = true)
public class ClientProfessionnelle extends Client {
    private String raisonSociale;
    private String numeroFiscale;
    private String siteweb;
}
