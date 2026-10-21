package rmschoolapi.dto.full;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rmschoolapi.dto.basic.EleveBasicDTO;
import rmschoolapi.dto.basic.CompteUtilisateurBasicDTO;
import rmschoolapi.dto.basic.InscriptionBasicDTO;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EleveFullDTO extends EleveBasicDTO {

    private CompteUtilisateurBasicDTO compteUtilisateur;
    private List<InscriptionBasicDTO> inscriptions = new ArrayList<>();
}
