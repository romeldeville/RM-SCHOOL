package rmschoolapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import rmschoolapi.dto.basic.EtablissementScolaireBasicDTO;
import rmschoolapi.dto.full.EtablissementScolaireFullDTO;
import rmschoolapi.entity.EtablissementScolaire;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EtablissementScolaireMapper {

    EtablissementScolaireBasicDTO toBasicDTO(EtablissementScolaire entity);

    List<EtablissementScolaireBasicDTO> toBasicDTOList(List<EtablissementScolaire> entities);

    EtablissementScolaire toEntity(EtablissementScolaireBasicDTO basicDTO);

    List<EtablissementScolaire> toEntityFromBasicList(List<EtablissementScolaireBasicDTO> basicDTOs);

    EtablissementScolaireFullDTO toFullDTO(EtablissementScolaire entity);

    List<EtablissementScolaireFullDTO> toFullDTOList(List<EtablissementScolaire> entities);

    EtablissementScolaire toEntity(EtablissementScolaireFullDTO fullDTO);

    List<EtablissementScolaire> toEntityFromFullList(List<EtablissementScolaireFullDTO> fullDTOs);

    void updateEntityFromBasicDTO(EtablissementScolaireBasicDTO basicDTO, @MappingTarget EtablissementScolaire entity);

    void updateEntityFromFullDTO(EtablissementScolaireFullDTO fullDTO, @MappingTarget EtablissementScolaire entity);
}
