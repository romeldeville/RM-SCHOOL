package rmschoolapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import rmschoolapi.dto.basic.InformationsPersonnelBasicDTO;
import rmschoolapi.dto.full.InformationsPersonnelFullDTO;
import rmschoolapi.entity.InformationsPersonnel;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InformationsPersonnelMapper {

    InformationsPersonnelBasicDTO toBasicDTO(InformationsPersonnel entity);

    List<InformationsPersonnelBasicDTO> toBasicDTOList(List<InformationsPersonnel> entities);

    InformationsPersonnel toEntity(InformationsPersonnelBasicDTO basicDTO);

    List<InformationsPersonnel> toEntityFromBasicList(List<InformationsPersonnelBasicDTO> basicDTOs);

    InformationsPersonnelFullDTO toFullDTO(InformationsPersonnel entity);

    List<InformationsPersonnelFullDTO> toFullDTOList(List<InformationsPersonnel> entities);

    InformationsPersonnel toEntity(InformationsPersonnelFullDTO fullDTO);

    List<InformationsPersonnel> toEntityFromFullList(List<InformationsPersonnelFullDTO> fullDTOs);

    void updateEntityFromBasicDTO(InformationsPersonnelBasicDTO basicDTO, @MappingTarget InformationsPersonnel entity);

    void updateEntityFromFullDTO(InformationsPersonnelFullDTO fullDTO, @MappingTarget InformationsPersonnel entity);
}
