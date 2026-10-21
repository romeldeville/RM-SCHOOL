package rmschoolapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import rmschoolapi.dto.basic.AnneeScolaireCouranteBasicDTO;
import rmschoolapi.dto.full.AnneeScolaireCouranteFullDTO;
import rmschoolapi.entity.AnneeScolaireCourante;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AnneeScolaireCouranteMapper {

    AnneeScolaireCouranteBasicDTO toBasicDTO(AnneeScolaireCourante entity);

    List<AnneeScolaireCouranteBasicDTO> toBasicDTOList(List<AnneeScolaireCourante> entities);

    AnneeScolaireCourante toEntity(AnneeScolaireCouranteBasicDTO basicDTO);

    List<AnneeScolaireCourante> toEntityFromBasicList(List<AnneeScolaireCouranteBasicDTO> basicDTOs);

    AnneeScolaireCouranteFullDTO toFullDTO(AnneeScolaireCourante entity);

    List<AnneeScolaireCouranteFullDTO> toFullDTOList(List<AnneeScolaireCourante> entities);

    AnneeScolaireCourante toEntity(AnneeScolaireCouranteFullDTO fullDTO);

    List<AnneeScolaireCourante> toEntityFromFullList(List<AnneeScolaireCouranteFullDTO> fullDTOs);

    void updateEntityFromBasicDTO(AnneeScolaireCouranteBasicDTO basicDTO, @MappingTarget AnneeScolaireCourante entity);

    void updateEntityFromFullDTO(AnneeScolaireCouranteFullDTO fullDTO, @MappingTarget AnneeScolaireCourante entity);
}
