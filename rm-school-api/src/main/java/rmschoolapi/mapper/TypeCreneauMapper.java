package rmschoolapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import rmschoolapi.dto.basic.TypeCreneauBasicDTO;
import rmschoolapi.dto.full.TypeCreneauFullDTO;
import rmschoolapi.entity.TypeCreneau;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TypeCreneauMapper {

    TypeCreneauBasicDTO toBasicDTO(TypeCreneau entity);

    List<TypeCreneauBasicDTO> toBasicDTOList(List<TypeCreneau> entities);

    TypeCreneau toEntity(TypeCreneauBasicDTO basicDTO);

    List<TypeCreneau> toEntityFromBasicList(List<TypeCreneauBasicDTO> basicDTOs);

    TypeCreneauFullDTO toFullDTO(TypeCreneau entity);

    List<TypeCreneauFullDTO> toFullDTOList(List<TypeCreneau> entities);

    TypeCreneau toEntity(TypeCreneauFullDTO fullDTO);

    List<TypeCreneau> toEntityFromFullList(List<TypeCreneauFullDTO> fullDTOs);

    void updateEntityFromBasicDTO(TypeCreneauBasicDTO basicDTO, @MappingTarget TypeCreneau entity);

    void updateEntityFromFullDTO(TypeCreneauFullDTO fullDTO, @MappingTarget TypeCreneau entity);
}
