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
public class EleveBasicDTO extends AbstractDTO {

    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private String lieuNaissance;
    private String sexe;
    private String nomPere;
    private String nomMere;
    private String nomTuteur;
    private String contactsParents;
}
