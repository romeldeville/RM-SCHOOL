package rmschoolapi.dto.full;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rmschoolapi.dto.basic.InscriptionBasicDTO;
import rmschoolapi.dto.basic.EleveBasicDTO;
import rmschoolapi.dto.basic.ClasseBasicDTO;
import rmschoolapi.dto.basic.NoteBasicDTO;
import rmschoolapi.dto.basic.DisciplineBasicDTO;
import rmschoolapi.dto.basic.PaiementBasicDTO;
import rmschoolapi.dto.basic.AbsenceEleveBasicDTO;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InscriptionFullDTO extends InscriptionBasicDTO {

    private EleveBasicDTO eleve;
    private ClasseBasicDTO classe;
    private List<NoteBasicDTO> notes = new ArrayList<>();
    private List<DisciplineBasicDTO> disciplines = new ArrayList<>();
    private List<PaiementBasicDTO> paiements = new ArrayList<>();
    private List<AbsenceEleveBasicDTO> absencesEleve = new ArrayList<>();
}
