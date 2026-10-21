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
public class DisciplineBasicDTO extends AbstractDTO {

    private Integer retardsTrimestre1;
    private Integer retardsTrimestre2;
    private Integer retardsTrimestre3;
    private Integer absencesNonJustifieesTrimestre1;
    private Integer absencesNonJustifieesTrimestre2;
    private Integer absencesNonJustifieesTrimestre3;
    private Integer absencesJustifieesTrimestre1;
    private Integer absencesJustifieesTrimestre2;
    private Integer absencesJustifieesTrimestre3;
    private Integer blamesTrimestre1;
    private Integer blamesTrimestre2;
    private Integer blamesTrimestre3;
    private Integer exclusionsTrimestre1;
    private Integer exclusionsTrimestre2;
    private Integer exclusionsTrimestre3;
    private Integer avertissementsTrimestre1;
    private Integer avertissementsTrimestre2;
    private Integer avertissementsTrimestre3;
    private Integer retenuesTrimestre1;
    private Integer retenuesTrimestre2;
    private Integer retenuesTrimestre3;
}
