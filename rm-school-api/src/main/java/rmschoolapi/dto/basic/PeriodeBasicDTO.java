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
public class PeriodeBasicDTO extends AbstractDTO {

    private String nom;
    private String nomAnglais;
    private String abreviation;
    private String abreviationAnglais;
    private LocalDate debut;
    private LocalDate fin;
    private Boolean statut;
}
