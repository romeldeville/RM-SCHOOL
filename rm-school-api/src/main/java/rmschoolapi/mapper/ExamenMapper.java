package rmschoolapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import rmschoolapi.dto.basic.ExamenBasicDTO;
import rmschoolapi.dto.full.ExamenFullDTO;
import rmschoolapi.entity.Examen;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ExamenMapper {

    ExamenBasicDTO toBasicDTO(Examen entity);

    List<ExamenBasicDTO> toBasicDTOList(List<Examen> entities);

    Examen toEntity(ExamenBasicDTO basicDTO);

    List<Examen> toEntityFromBasicList(List<ExamenBasicDTO> basicDTOs);

    ExamenFullDTO toFullDTO(Examen entity);

    List<ExamenFullDTO> toFullDTOList(List<Examen> entities);

    Examen toEntity(ExamenFullDTO fullDTO);

    List<Examen> toEntityFromFullList(List<ExamenFullDTO> fullDTOs);

    void updateEntityFromBasicDTO(ExamenBasicDTO basicDTO, @MappingTarget Examen entity);

    void updateEntityFromFullDTO(ExamenFullDTO fullDTO, @MappingTarget Examen entity);
}
