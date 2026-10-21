package rmschoolapi.dto.full;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rmschoolapi.dto.basic.PeriodeBasicDTO;
import rmschoolapi.dto.basic.AnneeScolaireBasicDTO;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PeriodeFullDTO extends PeriodeBasicDTO {

    private AnneeScolaireBasicDTO anneeScolaire;
}
