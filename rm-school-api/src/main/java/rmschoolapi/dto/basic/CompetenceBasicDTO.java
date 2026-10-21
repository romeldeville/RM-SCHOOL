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
public class CompetenceBasicDTO extends AbstractDTO {

    private String competencePremiereEvaluation;
    private String competenceDeuxiemeEvaluation;
    private String competenceTroisiemeEvaluation;
    private String competenceQuatriemeEvaluation;
    private String competenceCinquiemeEvaluation;
    private String competenceSixiemeEvaluation;
    private String competenceSeptiemeEvaluation;
    private String competenceHuitiemeEvaluation;
    private String competenceNeuviemeEvaluation;
}
