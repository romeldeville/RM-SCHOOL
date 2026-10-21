package rmschoolapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import rmschoolapi.dto.basic.EleveBasicDTO;
import rmschoolapi.dto.full.EleveFullDTO;
import rmschoolapi.entity.Eleve;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EleveMapper {

    EleveBasicDTO toBasicDTO(Eleve entity);

    List<EleveBasicDTO> toBasicDTOList(List<Eleve> entities);

    Eleve toEntity(EleveBasicDTO basicDTO);

    List<Eleve> toEntityFromBasicList(List<EleveBasicDTO> basicDTOs);

    EleveFullDTO toFullDTO(Eleve entity);

    List<EleveFullDTO> toFullDTOList(List<Eleve> entities);

    Eleve toEntity(EleveFullDTO fullDTO);

    List<Eleve> toEntityFromFullList(List<EleveFullDTO> fullDTOs);

    void updateEntityFromBasicDTO(EleveBasicDTO basicDTO, @MappingTarget Eleve entity);

    void updateEntityFromFullDTO(EleveFullDTO fullDTO, @MappingTarget Eleve entity);
}
