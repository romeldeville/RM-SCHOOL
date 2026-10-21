package rmschoolapi.dto.basic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rmschoolapi.dto.AbstractDTO;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ParametreBasicDTO extends AbstractDTO {

    private Integer nombreEvaluationsTrimestrielles;
    private String surfixeEnteteDocument;
    private LocalDate dateRentreeScolaire;
}
