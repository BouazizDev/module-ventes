package tn.codynet.moduleventes.services.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class FactureFournisseur extends AbstractEntity {
    private long id;
    //TODO
}
