package rmschoolapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import rmschoolapi.dto.basic.SectionBasicDTO;
import rmschoolapi.dto.full.SectionFullDTO;
import rmschoolapi.entity.Section;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SectionMapper {

    SectionBasicDTO toBasicDTO(Section entity);

    List<SectionBasicDTO> toBasicDTOList(List<Section> entities);

    Section toEntity(SectionBasicDTO basicDTO);

    List<Section> toEntityFromBasicList(List<SectionBasicDTO> basicDTOs);

    SectionFullDTO toFullDTO(Section entity);

    List<SectionFullDTO> toFullDTOList(List<Section> entities);

    Section toEntity(SectionFullDTO fullDTO);

    List<Section> toEntityFromFullList(List<SectionFullDTO> fullDTOs);

    void updateEntityFromBasicDTO(SectionBasicDTO basicDTO, @MappingTarget Section entity);

    void updateEntityFromFullDTO(SectionFullDTO fullDTO, @MappingTarget Section entity);
}
