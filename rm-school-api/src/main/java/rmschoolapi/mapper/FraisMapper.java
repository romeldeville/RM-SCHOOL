package rmschoolapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import rmschoolapi.dto.basic.FraisBasicDTO;
import rmschoolapi.dto.full.FraisFullDTO;
import rmschoolapi.entity.Frais;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FraisMapper {

    FraisBasicDTO toBasicDTO(Frais entity);

    List<FraisBasicDTO> toBasicDTOList(List<Frais> entities);

    Frais toEntity(FraisBasicDTO basicDTO);

    List<Frais> toEntityFromBasicList(List<FraisBasicDTO> basicDTOs);

    FraisFullDTO toFullDTO(Frais entity);

    List<FraisFullDTO> toFullDTOList(List<Frais> entities);

    Frais toEntity(FraisFullDTO fullDTO);

    List<Frais> toEntityFromFullList(List<FraisFullDTO> fullDTOs);

    void updateEntityFromBasicDTO(FraisBasicDTO basicDTO, @MappingTarget Frais entity);

    void updateEntityFromFullDTO(FraisFullDTO fullDTO, @MappingTarget Frais entity);
}
