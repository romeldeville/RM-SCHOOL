package rmschoolapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import rmschoolapi.dto.basic.PensionBasicDTO;
import rmschoolapi.dto.full.PensionFullDTO;
import rmschoolapi.entity.Pension;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PensionMapper {

    PensionBasicDTO toBasicDTO(Pension entity);

    List<PensionBasicDTO> toBasicDTOList(List<Pension> entities);

    Pension toEntity(PensionBasicDTO basicDTO);

    List<Pension> toEntityFromBasicList(List<PensionBasicDTO> basicDTOs);

    PensionFullDTO toFullDTO(Pension entity);

    List<PensionFullDTO> toFullDTOList(List<Pension> entities);

    Pension toEntity(PensionFullDTO fullDTO);

    List<Pension> toEntityFromFullList(List<PensionFullDTO> fullDTOs);

    void updateEntityFromBasicDTO(PensionBasicDTO basicDTO, @MappingTarget Pension entity);

    void updateEntityFromFullDTO(PensionFullDTO fullDTO, @MappingTarget Pension entity);
}
