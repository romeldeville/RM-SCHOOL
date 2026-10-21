package rmschoolapi.dto.full;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rmschoolapi.dto.basic.EtablissementScolaireBasicDTO;
import rmschoolapi.dto.basic.InformationsEtablissementScolaireBasicDTO;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EtablissementScolaireFullDTO extends EtablissementScolaireBasicDTO {

    private List<InformationsEtablissementScolaireBasicDTO> informationsEtablissementScolaires = new ArrayList<>();
}
