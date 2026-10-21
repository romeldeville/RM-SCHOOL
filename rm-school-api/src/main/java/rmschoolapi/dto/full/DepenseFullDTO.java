package rmschoolapi.dto.full;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rmschoolapi.dto.basic.DepenseBasicDTO;
import rmschoolapi.dto.basic.InformationsEtablissementScolaireBasicDTO;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepenseFullDTO extends DepenseBasicDTO {

    private InformationsEtablissementScolaireBasicDTO informationsEtablissementScolaire;
}
