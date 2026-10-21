package rmschoolapi.dto.full;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rmschoolapi.dto.basic.PaiementBasicDTO;
import rmschoolapi.dto.basic.InscriptionBasicDTO;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaiementFullDTO extends PaiementBasicDTO {

    private InscriptionBasicDTO inscription;
}
