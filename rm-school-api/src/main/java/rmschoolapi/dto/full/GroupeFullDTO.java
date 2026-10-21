package rmschoolapi.dto.full;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rmschoolapi.dto.basic.GroupeBasicDTO;
import rmschoolapi.dto.basic.CourNiveauBasicDTO;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GroupeFullDTO extends GroupeBasicDTO {

    private List<CourNiveauBasicDTO> coursNiveau = new ArrayList<>();
}
