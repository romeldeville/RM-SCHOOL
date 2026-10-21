package rmschoolapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import rmschoolapi.dto.basic.LigneEmploiDuTempsBasicDTO;
import rmschoolapi.dto.full.LigneEmploiDuTempsFullDTO;
import rmschoolapi.entity.LigneEmploiDuTemps;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LigneEmploiDuTempsMapper {

    LigneEmploiDuTempsBasicDTO toBasicDTO(LigneEmploiDuTemps entity);

    List<LigneEmploiDuTempsBasicDTO> toBasicDTOList(List<LigneEmploiDuTemps> entities);

    LigneEmploiDuTemps toEntity(LigneEmploiDuTempsBasicDTO basicDTO);

    List<LigneEmploiDuTemps> toEntityFromBasicList(List<LigneEmploiDuTempsBasicDTO> basicDTOs);

    LigneEmploiDuTempsFullDTO toFullDTO(LigneEmploiDuTemps entity);

    List<LigneEmploiDuTempsFullDTO> toFullDTOList(List<LigneEmploiDuTemps> entities);

    LigneEmploiDuTemps toEntity(LigneEmploiDuTempsFullDTO fullDTO);

    List<LigneEmploiDuTemps> toEntityFromFullList(List<LigneEmploiDuTempsFullDTO> fullDTOs);

    void updateEntityFromBasicDTO(LigneEmploiDuTempsBasicDTO basicDTO, @MappingTarget LigneEmploiDuTemps entity);

    void updateEntityFromFullDTO(LigneEmploiDuTempsFullDTO fullDTO, @MappingTarget LigneEmploiDuTemps entity);
}
