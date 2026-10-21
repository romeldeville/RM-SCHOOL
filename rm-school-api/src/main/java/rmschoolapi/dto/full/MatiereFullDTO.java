package rmschoolapi.dto.full;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rmschoolapi.dto.basic.MatiereBasicDTO;
import rmschoolapi.dto.basic.CourNiveauBasicDTO;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MatiereFullDTO extends MatiereBasicDTO {

    private List<CourNiveauBasicDTO> coursNiveau = new ArrayList<>();
}
