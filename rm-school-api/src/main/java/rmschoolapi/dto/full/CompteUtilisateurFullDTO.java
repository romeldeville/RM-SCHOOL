package rmschoolapi.dto.full;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rmschoolapi.dto.basic.CompteUtilisateurBasicDTO;
import rmschoolapi.dto.basic.StatutCompteUtilisateurBasicDTO;
import rmschoolapi.dto.basic.RoleBasicDTO;
import rmschoolapi.dto.basic.PersonnelBasicDTO;
import rmschoolapi.dto.basic.EleveBasicDTO;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompteUtilisateurFullDTO extends CompteUtilisateurBasicDTO {

    private StatutCompteUtilisateurBasicDTO statutCompteUtilisateur;
    private RoleBasicDTO role;
    private PersonnelBasicDTO personnel;
    private EleveBasicDTO eleve;
}
