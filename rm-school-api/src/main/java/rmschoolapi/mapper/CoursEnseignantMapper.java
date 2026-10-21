package rmschoolapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import rmschoolapi.dto.basic.CoursEnseignantBasicDTO;
import rmschoolapi.dto.full.CoursEnseignantFullDTO;
import rmschoolapi.entity.CoursEnseignant;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CoursEnseignantMapper {

    CoursEnseignantBasicDTO toBasicDTO(CoursEnseignant entity);

    List<CoursEnseignantBasicDTO> toBasicDTOList(List<CoursEnseignant> entities);

    CoursEnseignant toEntity(CoursEnseignantBasicDTO basicDTO);

    List<CoursEnseignant> toEntityFromBasicList(List<CoursEnseignantBasicDTO> basicDTOs);

    CoursEnseignantFullDTO toFullDTO(CoursEnseignant entity);

    List<CoursEnseignantFullDTO> toFullDTOList(List<CoursEnseignant> entities);

    CoursEnseignant toEntity(CoursEnseignantFullDTO fullDTO);

    List<CoursEnseignant> toEntityFromFullList(List<CoursEnseignantFullDTO> fullDTOs);

    void updateEntityFromBasicDTO(CoursEnseignantBasicDTO basicDTO, @MappingTarget CoursEnseignant entity);

    void updateEntityFromFullDTO(CoursEnseignantFullDTO fullDTO, @MappingTarget CoursEnseignant entity);
}
