package rmschoolapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import rmschoolapi.dto.basic.JourSemaineBasicDTO;
import rmschoolapi.dto.full.JourSemaineFullDTO;
import rmschoolapi.entity.JourSemaine;

import java.util.List;

@Mapper(componentModel = "spring")
public interface JourSemaineMapper {

    JourSemaineBasicDTO toBasicDTO(JourSemaine entity);

    List<JourSemaineBasicDTO> toBasicDTOList(List<JourSemaine> entities);

    JourSemaine toEntity(JourSemaineBasicDTO basicDTO);

    List<JourSemaine> toEntityFromBasicList(List<JourSemaineBasicDTO> basicDTOs);

    JourSemaineFullDTO toFullDTO(JourSemaine entity);

    List<JourSemaineFullDTO> toFullDTOList(List<JourSemaine> entities);

    JourSemaine toEntity(JourSemaineFullDTO fullDTO);

    List<JourSemaine> toEntityFromFullList(List<JourSemaineFullDTO> fullDTOs);

    void updateEntityFromBasicDTO(JourSemaineBasicDTO basicDTO, @MappingTarget JourSemaine entity);

    void updateEntityFromFullDTO(JourSemaineFullDTO fullDTO, @MappingTarget JourSemaine entity);
}
