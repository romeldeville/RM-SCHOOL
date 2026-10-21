package rmschoolapi.dto.full;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rmschoolapi.dto.basic.AbsenceEleveBasicDTO;
import rmschoolapi.dto.basic.InscriptionBasicDTO;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AbsenceEleveFullDTO extends AbsenceEleveBasicDTO {

    private InscriptionBasicDTO inscription;
}
