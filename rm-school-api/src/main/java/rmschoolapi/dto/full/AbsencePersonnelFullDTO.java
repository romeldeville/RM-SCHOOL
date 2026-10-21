package rmschoolapi.dto.full;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rmschoolapi.dto.basic.AbsencePersonnelBasicDTO;
import rmschoolapi.dto.basic.InformationsPersonnelBasicDTO;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AbsencePersonnelFullDTO extends AbsencePersonnelBasicDTO {

    private InformationsPersonnelBasicDTO informationsPersonnel;
}
