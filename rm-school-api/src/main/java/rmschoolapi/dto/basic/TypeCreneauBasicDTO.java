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
public class TypeCreneauBasicDTO extends AbstractDTO {

    private String nom;
    private String nomAnglais;
    private Integer dureeMinutes;
}
