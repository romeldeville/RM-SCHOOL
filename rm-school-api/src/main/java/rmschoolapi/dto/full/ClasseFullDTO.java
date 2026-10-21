package rmschoolapi.dto.full;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rmschoolapi.dto.basic.ClasseBasicDTO;
import rmschoolapi.dto.basic.NiveauBasicDTO;
import rmschoolapi.dto.basic.InscriptionBasicDTO;
import rmschoolapi.dto.basic.CoursEnseignantBasicDTO;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClasseFullDTO extends ClasseBasicDTO {

    private NiveauBasicDTO niveau;
    private List<InscriptionBasicDTO> inscriptions = new ArrayList<>();
    private List<CoursEnseignantBasicDTO> coursEnseignants = new ArrayList<>();
}
