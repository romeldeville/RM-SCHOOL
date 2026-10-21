package rmschoolapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import rmschoolapi.dto.basic.ClasseBasicDTO;
import rmschoolapi.dto.full.ClasseFullDTO;
import rmschoolapi.entity.Classe;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClasseMapper {

    ClasseBasicDTO toBasicDTO(Classe entity);

    List<ClasseBasicDTO> toBasicDTOList(List<Classe> entities);

    Classe toEntity(ClasseBasicDTO basicDTO);

    List<Classe> toEntityFromBasicList(List<ClasseBasicDTO> basicDTOs);

    ClasseFullDTO toFullDTO(Classe entity);

    List<ClasseFullDTO> toFullDTOList(List<Classe> entities);

    Classe toEntity(ClasseFullDTO fullDTO);

    List<Classe> toEntityFromFullList(List<ClasseFullDTO> fullDTOs);

    void updateEntityFromBasicDTO(ClasseBasicDTO basicDTO, @MappingTarget Classe entity);

    void updateEntityFromFullDTO(ClasseFullDTO fullDTO, @MappingTarget Classe entity);
}
