package rmschoolapi.dto.full;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rmschoolapi.dto.basic.CourNiveauBasicDTO;
import rmschoolapi.dto.basic.GroupeBasicDTO;
import rmschoolapi.dto.basic.MatiereBasicDTO;
import rmschoolapi.dto.basic.NiveauBasicDTO;
import rmschoolapi.dto.basic.CompetenceBasicDTO;
import rmschoolapi.dto.basic.CoursEnseignantBasicDTO;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourNiveauFullDTO extends CourNiveauBasicDTO {

    private GroupeBasicDTO groupe;
    private MatiereBasicDTO matiere;
    private NiveauBasicDTO niveau;
    private List<CompetenceBasicDTO> competences = new ArrayList<>();
    private List<CoursEnseignantBasicDTO> coursEnseignants = new ArrayList<>();
}
