package rmschoolapi.dto.full;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rmschoolapi.dto.basic.AnneeScolaireBasicDTO;
import rmschoolapi.dto.basic.InformationsEtablissementScolaireBasicDTO;
import rmschoolapi.dto.basic.AnneeScolaireCouranteBasicDTO;
import rmschoolapi.dto.basic.PeriodeBasicDTO;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnneeScolaireFullDTO extends AnneeScolaireBasicDTO {

    private List<InformationsEtablissementScolaireBasicDTO> informationsEtablissementScolaires = new ArrayList<>();
    private List<AnneeScolaireCouranteBasicDTO> anneesScolairesCourantes = new ArrayList<>();
    private List<PeriodeBasicDTO> periodes = new ArrayList<>();
}
