package rmschoolapi.dto.basic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rmschoolapi.dto.AbstractDTO;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NiveauBasicDTO extends AbstractDTO {

    private String nom;
    private Integer ageMinimalAdmis;
    private Integer ageMaximalAdmis;
    private Double moyenneAdmise;
    private Double moyennePassage;
}
