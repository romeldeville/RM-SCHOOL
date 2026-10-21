package rmschoolapi.dto.full;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rmschoolapi.dto.basic.CoursEnseignantBasicDTO;
import rmschoolapi.dto.basic.CourNiveauBasicDTO;
import rmschoolapi.dto.basic.ClasseBasicDTO;
import rmschoolapi.dto.basic.InformationsPersonnelBasicDTO;
import rmschoolapi.dto.basic.NoteBasicDTO;
import rmschoolapi.dto.basic.LigneEmploiDuTempsBasicDTO;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CoursEnseignantFullDTO extends CoursEnseignantBasicDTO {

    private CourNiveauBasicDTO courNiveau;
    private ClasseBasicDTO classe;
    private InformationsPersonnelBasicDTO informationsPersonnel;
    private List<NoteBasicDTO> notes = new ArrayList<>();
    private List<LigneEmploiDuTempsBasicDTO> ligneEmploiDuTempsList = new ArrayList<>();
}
