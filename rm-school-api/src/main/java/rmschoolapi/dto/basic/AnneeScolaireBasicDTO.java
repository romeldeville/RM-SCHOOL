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
public class AnneeScolaireBasicDTO extends AbstractDTO {

    private String nom;
    private String description;
    private String nomAnglais;
    private String descriptionAnglais;
}
