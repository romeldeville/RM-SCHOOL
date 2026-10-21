package rmschoolapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import rmschoolapi.dto.basic.PeriodeBasicDTO;
import rmschoolapi.dto.full.PeriodeFullDTO;
import rmschoolapi.entity.Periode;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PeriodeMapper {

    PeriodeBasicDTO toBasicDTO(Periode entity);

    List<PeriodeBasicDTO> toBasicDTOList(List<Periode> entities);

    Periode toEntity(PeriodeBasicDTO basicDTO);

    List<Periode> toEntityFromBasicList(List<PeriodeBasicDTO> basicDTOs);

    PeriodeFullDTO toFullDTO(Periode entity);

    List<PeriodeFullDTO> toFullDTOList(List<Periode> entities);

    Periode toEntity(PeriodeFullDTO fullDTO);

    List<Periode> toEntityFromFullList(List<PeriodeFullDTO> fullDTOs);

    void updateEntityFromBasicDTO(PeriodeBasicDTO basicDTO, @MappingTarget Periode entity);

    void updateEntityFromFullDTO(PeriodeFullDTO fullDTO, @MappingTarget Periode entity);
}
