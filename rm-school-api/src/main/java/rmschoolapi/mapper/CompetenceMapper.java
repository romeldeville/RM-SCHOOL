package rmschoolapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import rmschoolapi.dto.basic.CompetenceBasicDTO;
import rmschoolapi.dto.full.CompetenceFullDTO;
import rmschoolapi.entity.Competence;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompetenceMapper {

    CompetenceBasicDTO toBasicDTO(Competence entity);

    List<CompetenceBasicDTO> toBasicDTOList(List<Competence> entities);

    Competence toEntity(CompetenceBasicDTO basicDTO);

    List<Competence> toEntityFromBasicList(List<CompetenceBasicDTO> basicDTOs);

    CompetenceFullDTO toFullDTO(Competence entity);

    List<CompetenceFullDTO> toFullDTOList(List<Competence> entities);

    Competence toEntity(CompetenceFullDTO fullDTO);

    List<Competence> toEntityFromFullList(List<CompetenceFullDTO> fullDTOs);

    void updateEntityFromBasicDTO(CompetenceBasicDTO basicDTO, @MappingTarget Competence entity);

    void updateEntityFromFullDTO(CompetenceFullDTO fullDTO, @MappingTarget Competence entity);
}
