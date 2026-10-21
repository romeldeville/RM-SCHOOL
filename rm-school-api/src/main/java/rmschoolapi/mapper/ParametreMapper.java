package rmschoolapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import rmschoolapi.dto.basic.ParametreBasicDTO;
import rmschoolapi.dto.full.ParametreFullDTO;
import rmschoolapi.entity.Parametre;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ParametreMapper {

    ParametreBasicDTO toBasicDTO(Parametre entity);

    List<ParametreBasicDTO> toBasicDTOList(List<Parametre> entities);

    Parametre toEntity(ParametreBasicDTO basicDTO);

    List<Parametre> toEntityFromBasicList(List<ParametreBasicDTO> basicDTOs);

    ParametreFullDTO toFullDTO(Parametre entity);

    List<ParametreFullDTO> toFullDTOList(List<Parametre> entities);

    Parametre toEntity(ParametreFullDTO fullDTO);

    List<Parametre> toEntityFromFullList(List<ParametreFullDTO> fullDTOs);

    void updateEntityFromBasicDTO(ParametreBasicDTO basicDTO, @MappingTarget Parametre entity);

    void updateEntityFromFullDTO(ParametreFullDTO fullDTO, @MappingTarget Parametre entity);
}
