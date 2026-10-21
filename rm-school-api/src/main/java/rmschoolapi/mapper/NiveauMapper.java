package rmschoolapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import rmschoolapi.dto.basic.NiveauBasicDTO;
import rmschoolapi.dto.full.NiveauFullDTO;
import rmschoolapi.entity.Niveau;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NiveauMapper {

    NiveauBasicDTO toBasicDTO(Niveau entity);

    List<NiveauBasicDTO> toBasicDTOList(List<Niveau> entities);

    Niveau toEntity(NiveauBasicDTO basicDTO);

    List<Niveau> toEntityFromBasicList(List<NiveauBasicDTO> basicDTOs);

    NiveauFullDTO toFullDTO(Niveau entity);

    List<NiveauFullDTO> toFullDTOList(List<Niveau> entities);

    Niveau toEntity(NiveauFullDTO fullDTO);

    List<Niveau> toEntityFromFullList(List<NiveauFullDTO> fullDTOs);

    void updateEntityFromBasicDTO(NiveauBasicDTO basicDTO, @MappingTarget Niveau entity);

    void updateEntityFromFullDTO(NiveauFullDTO fullDTO, @MappingTarget Niveau entity);
}
