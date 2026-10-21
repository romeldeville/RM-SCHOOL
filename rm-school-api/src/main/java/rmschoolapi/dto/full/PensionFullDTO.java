package rmschoolapi.dto.full;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rmschoolapi.dto.basic.PensionBasicDTO;
import rmschoolapi.dto.basic.NiveauBasicDTO;
import rmschoolapi.dto.basic.FraisBasicDTO;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PensionFullDTO extends PensionBasicDTO {

    private List<NiveauBasicDTO> niveaux = new ArrayList<>();
    private List<FraisBasicDTO> fraisList = new ArrayList<>();
}
