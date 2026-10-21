package rmschoolapi.dto.full;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rmschoolapi.dto.basic.SectionBasicDTO;
import rmschoolapi.dto.basic.InformationsEtablissementScolaireBasicDTO;
import rmschoolapi.dto.basic.CycleBasicDTO;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SectionFullDTO extends SectionBasicDTO {

    private InformationsEtablissementScolaireBasicDTO informationsEtablissementScolaire;
    private List<CycleBasicDTO> cycles = new ArrayList<>();
}
