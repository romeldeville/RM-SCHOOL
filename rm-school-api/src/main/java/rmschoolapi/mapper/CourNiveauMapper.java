package rmschoolapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import rmschoolapi.dto.basic.CourNiveauBasicDTO;
import rmschoolapi.dto.full.CourNiveauFullDTO;
import rmschoolapi.entity.CourNiveau;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourNiveauMapper {

    CourNiveauBasicDTO toBasicDTO(CourNiveau entity);

    List<CourNiveauBasicDTO> toBasicDTOList(List<CourNiveau> entities);

    CourNiveau toEntity(CourNiveauBasicDTO basicDTO);

    List<CourNiveau> toEntityFromBasicList(List<CourNiveauBasicDTO> basicDTOs);

    CourNiveauFullDTO toFullDTO(CourNiveau entity);

    List<CourNiveauFullDTO> toFullDTOList(List<CourNiveau> entities);

    CourNiveau toEntity(CourNiveauFullDTO fullDTO);

    List<CourNiveau> toEntityFromFullList(List<CourNiveauFullDTO> fullDTOs);

    void updateEntityFromBasicDTO(CourNiveauBasicDTO basicDTO, @MappingTarget CourNiveau entity);

    void updateEntityFromFullDTO(CourNiveauFullDTO fullDTO, @MappingTarget CourNiveau entity);
}
