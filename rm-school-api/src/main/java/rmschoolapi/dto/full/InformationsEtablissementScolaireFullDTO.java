package rmschoolapi.dto.full;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rmschoolapi.dto.basic.InformationsEtablissementScolaireBasicDTO;
import rmschoolapi.dto.basic.AnneeScolaireBasicDTO;
import rmschoolapi.dto.basic.EtablissementScolaireBasicDTO;
import rmschoolapi.dto.basic.ParametreBasicDTO;
import rmschoolapi.dto.basic.DepenseBasicDTO;
import rmschoolapi.dto.basic.SectionBasicDTO;
import rmschoolapi.dto.basic.InformationsPersonnelBasicDTO;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InformationsEtablissementScolaireFullDTO extends InformationsEtablissementScolaireBasicDTO {

    private AnneeScolaireBasicDTO anneeScolaire;
    private EtablissementScolaireBasicDTO etablissementScolaire;
    private List<ParametreBasicDTO> parametres = new ArrayList<>();
    private List<DepenseBasicDTO> depenses = new ArrayList<>();
    private List<SectionBasicDTO> sections = new ArrayList<>();
    private List<InformationsPersonnelBasicDTO> informationsPersonnels = new ArrayList<>();
}
