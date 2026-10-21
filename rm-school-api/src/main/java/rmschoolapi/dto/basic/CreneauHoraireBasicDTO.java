package rmschoolapi.dto.basic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rmschoolapi.dto.AbstractDTO;

import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreneauHoraireBasicDTO extends AbstractDTO {

    private LocalTime heureDebut;
    private LocalTime heureFin;
    private Integer ordre;
}
