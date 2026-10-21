package rmschoolapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public abstract class AbstractDTO {

    private Long id;
    private LocalDateTime dateEnregistrement;
    private LocalDateTime dateModification;
    private Long responsableEnregistrement;
    private Long responsableModification;
}
