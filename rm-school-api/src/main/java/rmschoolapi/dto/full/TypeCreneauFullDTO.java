package rmschoolapi.dto.full;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rmschoolapi.dto.basic.TypeCreneauBasicDTO;
import rmschoolapi.dto.basic.CreneauHoraireBasicDTO;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TypeCreneauFullDTO extends TypeCreneauBasicDTO {

    private List<CreneauHoraireBasicDTO> creneauxHoraires = new ArrayList<>();
}
