package rmschoolapi.dto.full;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rmschoolapi.dto.basic.ParametreBasicDTO;
import rmschoolapi.dto.basic.InformationsEtablissementScolaireBasicDTO;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ParametreFullDTO extends ParametreBasicDTO {

    private InformationsEtablissementScolaireBasicDTO informationsEtablissementScolaire;
}
