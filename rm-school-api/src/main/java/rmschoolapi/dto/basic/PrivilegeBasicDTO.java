package rmschoolapi.dto.basic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rmschoolapi.dto.AbstractDTO;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PrivilegeBasicDTO extends AbstractDTO {

    private String nom;
    private String nomAnglais;
    private String description;
    private String descriptionAnglais;
    private Boolean statut;
}
