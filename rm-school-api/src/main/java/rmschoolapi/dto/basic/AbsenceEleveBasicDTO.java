package rmschoolapi.dto.basic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rmschoolapi.dto.AbstractDTO;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AbsenceEleveBasicDTO extends AbstractDTO {

    private LocalDate dateAppel;
    private LocalTime heureDebut;
    private LocalTime heureFin;
    private String commentaire;
    private String justificatif;
    private String documentPath;
    private Boolean valide;
    private LocalDate dateValidation;
    private Long validePar;
}
