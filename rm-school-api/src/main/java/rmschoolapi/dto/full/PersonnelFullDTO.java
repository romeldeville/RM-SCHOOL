package rmschoolapi.dto.full;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rmschoolapi.dto.basic.PersonnelBasicDTO;
import rmschoolapi.dto.basic.CompteUtilisateurBasicDTO;
import rmschoolapi.dto.basic.InformationsPersonnelBasicDTO;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonnelFullDTO extends PersonnelBasicDTO {

    private CompteUtilisateurBasicDTO compteUtilisateur;
    private List<InformationsPersonnelBasicDTO> informationsPersonnels = new ArrayList<>();
}
