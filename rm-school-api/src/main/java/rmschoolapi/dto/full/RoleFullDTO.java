package rmschoolapi.dto.full;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rmschoolapi.dto.basic.RoleBasicDTO;
import rmschoolapi.dto.basic.CompteUtilisateurBasicDTO;
import rmschoolapi.dto.basic.PrivilegeBasicDTO;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleFullDTO extends RoleBasicDTO {

    private List<CompteUtilisateurBasicDTO> compteUtilisateurs = new ArrayList<>();
    private List<PrivilegeBasicDTO> privileges = new ArrayList<>();
}
