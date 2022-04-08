package tn.codynet.moduleventes.services.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FactureClient extends AbstractEntity {
    private long id;
    //TODO
}
