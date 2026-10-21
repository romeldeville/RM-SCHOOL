package rmschoolapi.dto.full;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rmschoolapi.dto.basic.CycleBasicDTO;
import rmschoolapi.dto.basic.SectionBasicDTO;
import rmschoolapi.dto.basic.NiveauBasicDTO;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CycleFullDTO extends CycleBasicDTO {

    private SectionBasicDTO section;
    private List<NiveauBasicDTO> niveaux = new ArrayList<>();
}
