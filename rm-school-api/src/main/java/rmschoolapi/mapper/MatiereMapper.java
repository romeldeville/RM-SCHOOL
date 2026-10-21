package rmschoolapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import rmschoolapi.dto.basic.MatiereBasicDTO;
import rmschoolapi.dto.full.MatiereFullDTO;
import rmschoolapi.entity.Matiere;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MatiereMapper {

    MatiereBasicDTO toBasicDTO(Matiere entity);

    List<MatiereBasicDTO> toBasicDTOList(List<Matiere> entities);

    Matiere toEntity(MatiereBasicDTO basicDTO);

    List<Matiere> toEntityFromBasicList(List<MatiereBasicDTO> basicDTOs);

    MatiereFullDTO toFullDTO(Matiere entity);

    List<MatiereFullDTO> toFullDTOList(List<Matiere> entities);

    Matiere toEntity(MatiereFullDTO fullDTO);

    List<Matiere> toEntityFromFullList(List<MatiereFullDTO> fullDTOs);

    void updateEntityFromBasicDTO(MatiereBasicDTO basicDTO, @MappingTarget Matiere entity);

    void updateEntityFromFullDTO(MatiereFullDTO fullDTO, @MappingTarget Matiere entity);
}
