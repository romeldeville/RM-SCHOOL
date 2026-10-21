package rmschoolapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import rmschoolapi.dto.basic.AbsenceEleveBasicDTO;
import rmschoolapi.dto.full.AbsenceEleveFullDTO;
import rmschoolapi.entity.AbsenceEleve;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AbsenceEleveMapper {

    AbsenceEleveBasicDTO toBasicDTO(AbsenceEleve entity);

    List<AbsenceEleveBasicDTO> toBasicDTOList(List<AbsenceEleve> entities);

    AbsenceEleve toEntity(AbsenceEleveBasicDTO basicDTO);

    List<AbsenceEleve> toEntityFromBasicList(List<AbsenceEleveBasicDTO> basicDTOs);

    AbsenceEleveFullDTO toFullDTO(AbsenceEleve entity);

    List<AbsenceEleveFullDTO> toFullDTOList(List<AbsenceEleve> entities);

    AbsenceEleve toEntity(AbsenceEleveFullDTO fullDTO);

    List<AbsenceEleve> toEntityFromFullList(List<AbsenceEleveFullDTO> fullDTOs);

    void updateEntityFromBasicDTO(AbsenceEleveBasicDTO basicDTO, @MappingTarget AbsenceEleve entity);

    void updateEntityFromFullDTO(AbsenceEleveFullDTO fullDTO, @MappingTarget AbsenceEleve entity);
}
