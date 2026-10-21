package rmschoolapi.dto.full;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rmschoolapi.dto.basic.StatutCompteUtilisateurBasicDTO;
import rmschoolapi.dto.basic.CompteUtilisateurBasicDTO;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StatutCompteUtilisateurFullDTO extends StatutCompteUtilisateurBasicDTO {

    private List<CompteUtilisateurBasicDTO> compteUtilisateurs = new ArrayList<>();
}
