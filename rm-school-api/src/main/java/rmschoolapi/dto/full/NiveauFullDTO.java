package rmschoolapi.dto.full;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rmschoolapi.dto.basic.NiveauBasicDTO;
import rmschoolapi.dto.basic.PensionBasicDTO;
import rmschoolapi.dto.basic.CycleBasicDTO;
import rmschoolapi.dto.basic.ClasseBasicDTO;
import rmschoolapi.dto.basic.CourNiveauBasicDTO;
import rmschoolapi.dto.basic.ExamenBasicDTO;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NiveauFullDTO extends NiveauBasicDTO {

    private PensionBasicDTO pension;
    private CycleBasicDTO cycle;
    private List<ClasseBasicDTO> classes = new ArrayList<>();
    private List<CourNiveauBasicDTO> coursNiveau = new ArrayList<>();
    private List<ExamenBasicDTO> examens = new ArrayList<>();
}
