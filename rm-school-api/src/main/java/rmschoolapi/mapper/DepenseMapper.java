package rmschoolapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import rmschoolapi.dto.basic.DepenseBasicDTO;
import rmschoolapi.dto.full.DepenseFullDTO;
import rmschoolapi.entity.Depense;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DepenseMapper {

    DepenseBasicDTO toBasicDTO(Depense entity);

    List<DepenseBasicDTO> toBasicDTOList(List<Depense> entities);

    Depense toEntity(DepenseBasicDTO basicDTO);

    List<Depense> toEntityFromBasicList(List<DepenseBasicDTO> basicDTOs);

    DepenseFullDTO toFullDTO(Depense entity);

    List<DepenseFullDTO> toFullDTOList(List<Depense> entities);

    Depense toEntity(DepenseFullDTO fullDTO);

    List<Depense> toEntityFromFullList(List<DepenseFullDTO> fullDTOs);

    void updateEntityFromBasicDTO(DepenseBasicDTO basicDTO, @MappingTarget Depense entity);

    void updateEntityFromFullDTO(DepenseFullDTO fullDTO, @MappingTarget Depense entity);
}
