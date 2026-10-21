package rmschoolapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import rmschoolapi.dto.basic.InformationsEtablissementScolaireBasicDTO;
import rmschoolapi.dto.full.InformationsEtablissementScolaireFullDTO;
import rmschoolapi.entity.InformationsEtablissementScolaire;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InformationsEtablissementScolaireMapper {

    InformationsEtablissementScolaireBasicDTO toBasicDTO(InformationsEtablissementScolaire entity);

    List<InformationsEtablissementScolaireBasicDTO> toBasicDTOList(List<InformationsEtablissementScolaire> entities);

    InformationsEtablissementScolaire toEntity(InformationsEtablissementScolaireBasicDTO basicDTO);

    List<InformationsEtablissementScolaire> toEntityFromBasicList(List<InformationsEtablissementScolaireBasicDTO> basicDTOs);

    InformationsEtablissementScolaireFullDTO toFullDTO(InformationsEtablissementScolaire entity);

    List<InformationsEtablissementScolaireFullDTO> toFullDTOList(List<InformationsEtablissementScolaire> entities);

    InformationsEtablissementScolaire toEntity(InformationsEtablissementScolaireFullDTO fullDTO);

    List<InformationsEtablissementScolaire> toEntityFromFullList(List<InformationsEtablissementScolaireFullDTO> fullDTOs);

    void updateEntityFromBasicDTO(InformationsEtablissementScolaireBasicDTO basicDTO, @MappingTarget InformationsEtablissementScolaire entity);

    void updateEntityFromFullDTO(InformationsEtablissementScolaireFullDTO fullDTO, @MappingTarget InformationsEtablissementScolaire entity);
}
