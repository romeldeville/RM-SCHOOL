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
public class NoteBasicDTO extends AbstractDTO {

    private Double premiereEvaluation;
    private Double deuxiemeEvaluation;
    private Double troisiemeEvaluation;
    private Double quatriemeEvaluation;
    private Double cinquiemeEvaluation;
    private Double sixiemeEvaluation;
    private Double septiemeEvaluation;
    private Double huitiemeEvaluation;
    private Double neuviemeEvaluation;
}
