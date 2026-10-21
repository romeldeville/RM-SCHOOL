package rmschoolapi.dto.full;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rmschoolapi.dto.basic.InformationsPersonnelBasicDTO;
import rmschoolapi.dto.basic.PersonnelBasicDTO;
import rmschoolapi.dto.basic.InformationsEtablissementScolaireBasicDTO;
import rmschoolapi.dto.basic.AbsencePersonnelBasicDTO;
import rmschoolapi.dto.basic.CoursEnseignantBasicDTO;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InformationsPersonnelFullDTO extends InformationsPersonnelBasicDTO {

    private PersonnelBasicDTO personnel;
    private InformationsEtablissementScolaireBasicDTO informationsEtablissementScolaire;
    private List<AbsencePersonnelBasicDTO> absencesPersonnel = new ArrayList<>();
    private List<CoursEnseignantBasicDTO> coursEnseignants = new ArrayList<>();
}
