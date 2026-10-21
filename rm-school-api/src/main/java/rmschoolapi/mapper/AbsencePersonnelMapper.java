package rmschoolapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import rmschoolapi.dto.basic.AbsencePersonnelBasicDTO;
import rmschoolapi.dto.full.AbsencePersonnelFullDTO;
import rmschoolapi.entity.AbsencePersonnel;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AbsencePersonnelMapper {

    AbsencePersonnelBasicDTO toBasicDTO(AbsencePersonnel entity);

    List<AbsencePersonnelBasicDTO> toBasicDTOList(List<AbsencePersonnel> entities);

    AbsencePersonnel toEntity(AbsencePersonnelBasicDTO basicDTO);

    List<AbsencePersonnel> toEntityFromBasicList(List<AbsencePersonnelBasicDTO> basicDTOs);

    AbsencePersonnelFullDTO toFullDTO(AbsencePersonnel entity);

    List<AbsencePersonnelFullDTO> toFullDTOList(List<AbsencePersonnel> entities);

    AbsencePersonnel toEntity(AbsencePersonnelFullDTO fullDTO);

    List<AbsencePersonnel> toEntityFromFullList(List<AbsencePersonnelFullDTO> fullDTOs);

    void updateEntityFromBasicDTO(AbsencePersonnelBasicDTO basicDTO, @MappingTarget AbsencePersonnel entity);

    void updateEntityFromFullDTO(AbsencePersonnelFullDTO fullDTO, @MappingTarget AbsencePersonnel entity);
}
