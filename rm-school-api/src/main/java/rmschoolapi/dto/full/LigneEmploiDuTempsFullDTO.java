package rmschoolapi.dto.full;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rmschoolapi.dto.basic.LigneEmploiDuTempsBasicDTO;
import rmschoolapi.dto.basic.JourSemaineBasicDTO;
import rmschoolapi.dto.basic.CreneauHoraireBasicDTO;
import rmschoolapi.dto.basic.CoursEnseignantBasicDTO;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LigneEmploiDuTempsFullDTO extends LigneEmploiDuTempsBasicDTO {

    private JourSemaineBasicDTO jourSemaine;
    private CreneauHoraireBasicDTO creneauHoraire;
    private CoursEnseignantBasicDTO coursEnseignant;
}
