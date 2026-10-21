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
public class PersonnelBasicDTO extends AbstractDTO {

    private String nom;
    private String prenom;
    private String sexe;
    private String contacts;
    private LocalDate dateNaissance;
    private String lieuNaissance;
    private String ethnie;
    private String nomPere;
    private String nomMere;
}
