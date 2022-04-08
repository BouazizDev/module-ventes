package tn.codynet.moduleventes.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Adresse  {
    private String adresse1;
    private String adresse2;
    private String ville;
    private String pays;
    private String codePostale;
}
