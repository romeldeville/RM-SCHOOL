package rmschoolapi.dto.full;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rmschoolapi.dto.basic.NoteBasicDTO;
import rmschoolapi.dto.basic.InscriptionBasicDTO;
import rmschoolapi.dto.basic.CoursEnseignantBasicDTO;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NoteFullDTO extends NoteBasicDTO {

    private InscriptionBasicDTO inscription;
    private CoursEnseignantBasicDTO coursEnseignant;
}
