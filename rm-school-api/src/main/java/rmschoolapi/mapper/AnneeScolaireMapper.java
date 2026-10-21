package rmschoolapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import rmschoolapi.dto.basic.AnneeScolaireBasicDTO;
import rmschoolapi.dto.full.AnneeScolaireFullDTO;
import rmschoolapi.entity.AnneeScolaire;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AnneeScolaireMapper {

    AnneeScolaireBasicDTO toBasicDTO(AnneeScolaire entity);

    List<AnneeScolaireBasicDTO> toBasicDTOList(List<AnneeScolaire> entities);

    AnneeScolaire toEntity(AnneeScolaireBasicDTO basicDTO);

    List<AnneeScolaire> toEntityFromBasicList(List<AnneeScolaireBasicDTO> basicDTOs);

    AnneeScolaireFullDTO toFullDTO(AnneeScolaire entity);

    List<AnneeScolaireFullDTO> toFullDTOList(List<AnneeScolaire> entities);

    AnneeScolaire toEntity(AnneeScolaireFullDTO fullDTO);

    List<AnneeScolaire> toEntityFromFullList(List<AnneeScolaireFullDTO> fullDTOs);

    void updateEntityFromBasicDTO(AnneeScolaireBasicDTO basicDTO, @MappingTarget AnneeScolaire entity);

    void updateEntityFromFullDTO(AnneeScolaireFullDTO fullDTO, @MappingTarget AnneeScolaire entity);
}
