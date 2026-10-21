package rmschoolapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import rmschoolapi.dto.basic.CycleBasicDTO;
import rmschoolapi.dto.full.CycleFullDTO;
import rmschoolapi.entity.Cycle;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CycleMapper {

    CycleBasicDTO toBasicDTO(Cycle entity);

    List<CycleBasicDTO> toBasicDTOList(List<Cycle> entities);

    Cycle toEntity(CycleBasicDTO basicDTO);

    List<Cycle> toEntityFromBasicList(List<CycleBasicDTO> basicDTOs);

    CycleFullDTO toFullDTO(Cycle entity);

    List<CycleFullDTO> toFullDTOList(List<Cycle> entities);

    Cycle toEntity(CycleFullDTO fullDTO);

    List<Cycle> toEntityFromFullList(List<CycleFullDTO> fullDTOs);

    void updateEntityFromBasicDTO(CycleBasicDTO basicDTO, @MappingTarget Cycle entity);

    void updateEntityFromFullDTO(CycleFullDTO fullDTO, @MappingTarget Cycle entity);
}
