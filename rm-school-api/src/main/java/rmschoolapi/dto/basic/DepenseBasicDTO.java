package rmschoolapi.dto.basic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rmschoolapi.dto.AbstractDTO;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepenseBasicDTO extends AbstractDTO {

    private String motif;
    private LocalDateTime dateDepense;
    private Double montant;
    private String devise;
}
