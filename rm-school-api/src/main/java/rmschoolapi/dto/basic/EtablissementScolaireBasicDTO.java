package rmschoolapi.dto.basic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rmschoolapi.dto.AbstractDTO;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EtablissementScolaireBasicDTO extends AbstractDTO {

    private String immatriculation;
    private LocalDate dateCreation;
    private LocalDate dateOuverture;
    private String nomFondateur;
    private String contactFondateur;
}
