package rmschoolapi.dto.full;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rmschoolapi.dto.basic.CompetenceBasicDTO;
import rmschoolapi.dto.basic.CourNiveauBasicDTO;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompetenceFullDTO extends CompetenceBasicDTO {

    private CourNiveauBasicDTO courNiveau;
}
