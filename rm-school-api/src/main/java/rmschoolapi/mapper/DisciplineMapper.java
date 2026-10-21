package rmschoolapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import rmschoolapi.dto.basic.DisciplineBasicDTO;
import rmschoolapi.dto.full.DisciplineFullDTO;
import rmschoolapi.entity.Discipline;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DisciplineMapper {

    DisciplineBasicDTO toBasicDTO(Discipline entity);

    List<DisciplineBasicDTO> toBasicDTOList(List<Discipline> entities);

    Discipline toEntity(DisciplineBasicDTO basicDTO);

    List<Discipline> toEntityFromBasicList(List<DisciplineBasicDTO> basicDTOs);

    DisciplineFullDTO toFullDTO(Discipline entity);

    List<DisciplineFullDTO> toFullDTOList(List<Discipline> entities);

    Discipline toEntity(DisciplineFullDTO fullDTO);

    List<Discipline> toEntityFromFullList(List<DisciplineFullDTO> fullDTOs);

    void updateEntityFromBasicDTO(DisciplineBasicDTO basicDTO, @MappingTarget Discipline entity);

    void updateEntityFromFullDTO(DisciplineFullDTO fullDTO, @MappingTarget Discipline entity);
}
