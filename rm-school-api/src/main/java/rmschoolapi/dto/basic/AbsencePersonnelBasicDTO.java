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
public class AbsencePersonnelBasicDTO extends AbstractDTO {

    private LocalDate dateAbsence;
    private LocalTime heureDebut;
    private LocalTime heureFin;
    private String motif;
    private String typeAbsence;
    private String commentaire;
    private String documentPath;
    private Boolean approuve;
    private LocalDate dateApprobation;
    private Long approuvePar;
}
