package rmschoolapi.dto.full;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rmschoolapi.dto.basic.FraisBasicDTO;
import rmschoolapi.dto.basic.PensionBasicDTO;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FraisFullDTO extends FraisBasicDTO {

    private PensionBasicDTO pension;
}
