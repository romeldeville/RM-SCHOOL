package rmschoolapi.dto.full;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rmschoolapi.dto.basic.CreneauHoraireBasicDTO;
import rmschoolapi.dto.basic.TypeCreneauBasicDTO;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreneauHoraireFullDTO extends CreneauHoraireBasicDTO {

    private TypeCreneauBasicDTO typeCreneau;
}
