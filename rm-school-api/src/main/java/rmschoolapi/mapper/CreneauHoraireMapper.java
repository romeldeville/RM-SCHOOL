package rmschoolapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import rmschoolapi.dto.basic.CreneauHoraireBasicDTO;
import rmschoolapi.dto.full.CreneauHoraireFullDTO;
import rmschoolapi.entity.CreneauHoraire;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CreneauHoraireMapper {

    CreneauHoraireBasicDTO toBasicDTO(CreneauHoraire entity);

    List<CreneauHoraireBasicDTO> toBasicDTOList(List<CreneauHoraire> entities);

    CreneauHoraire toEntity(CreneauHoraireBasicDTO basicDTO);

    List<CreneauHoraire> toEntityFromBasicList(List<CreneauHoraireBasicDTO> basicDTOs);

    CreneauHoraireFullDTO toFullDTO(CreneauHoraire entity);

    List<CreneauHoraireFullDTO> toFullDTOList(List<CreneauHoraire> entities);

    CreneauHoraire toEntity(CreneauHoraireFullDTO fullDTO);

    List<CreneauHoraire> toEntityFromFullList(List<CreneauHoraireFullDTO> fullDTOs);

    void updateEntityFromBasicDTO(CreneauHoraireBasicDTO basicDTO, @MappingTarget CreneauHoraire entity);

    void updateEntityFromFullDTO(CreneauHoraireFullDTO fullDTO, @MappingTarget CreneauHoraire entity);
}
