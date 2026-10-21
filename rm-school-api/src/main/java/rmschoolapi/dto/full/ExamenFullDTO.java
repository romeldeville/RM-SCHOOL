package rmschoolapi.dto.full;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rmschoolapi.dto.basic.ExamenBasicDTO;
import rmschoolapi.dto.basic.NiveauBasicDTO;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExamenFullDTO extends ExamenBasicDTO {

    private List<NiveauBasicDTO> niveaux = new ArrayList<>();
}
