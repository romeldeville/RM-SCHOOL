package rmschoolapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import rmschoolapi.dto.basic.PersonnelBasicDTO;
import rmschoolapi.dto.full.PersonnelFullDTO;
import rmschoolapi.entity.Personnel;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonnelMapper {

    PersonnelBasicDTO toBasicDTO(Personnel entity);

    List<PersonnelBasicDTO> toBasicDTOList(List<Personnel> entities);

    Personnel toEntity(PersonnelBasicDTO basicDTO);

    List<Personnel> toEntityFromBasicList(List<PersonnelBasicDTO> basicDTOs);

    PersonnelFullDTO toFullDTO(Personnel entity);

    List<PersonnelFullDTO> toFullDTOList(List<Personnel> entities);

    Personnel toEntity(PersonnelFullDTO fullDTO);

    List<Personnel> toEntityFromFullList(List<PersonnelFullDTO> fullDTOs);

    void updateEntityFromBasicDTO(PersonnelBasicDTO basicDTO, @MappingTarget Personnel entity);

    void updateEntityFromFullDTO(PersonnelFullDTO fullDTO, @MappingTarget Personnel entity);
}
