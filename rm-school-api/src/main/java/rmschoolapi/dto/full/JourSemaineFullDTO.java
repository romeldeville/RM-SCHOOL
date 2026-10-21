package rmschoolapi.dto.full;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rmschoolapi.dto.basic.JourSemaineBasicDTO;
import rmschoolapi.dto.basic.LigneEmploiDuTempsBasicDTO;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JourSemaineFullDTO extends JourSemaineBasicDTO {

    private List<LigneEmploiDuTempsBasicDTO> ligneEmploiDuTempsList = new ArrayList<>();
}
