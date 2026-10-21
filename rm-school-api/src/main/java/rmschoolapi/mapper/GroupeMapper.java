package rmschoolapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import rmschoolapi.dto.basic.GroupeBasicDTO;
import rmschoolapi.dto.full.GroupeFullDTO;
import rmschoolapi.entity.Groupe;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GroupeMapper {

    GroupeBasicDTO toBasicDTO(Groupe entity);

    List<GroupeBasicDTO> toBasicDTOList(List<Groupe> entities);

    Groupe toEntity(GroupeBasicDTO basicDTO);

    List<Groupe> toEntityFromBasicList(List<GroupeBasicDTO> basicDTOs);

    GroupeFullDTO toFullDTO(Groupe entity);

    List<GroupeFullDTO> toFullDTOList(List<Groupe> entities);

    Groupe toEntity(GroupeFullDTO fullDTO);

    List<Groupe> toEntityFromFullList(List<GroupeFullDTO> fullDTOs);

    void updateEntityFromBasicDTO(GroupeBasicDTO basicDTO, @MappingTarget Groupe entity);

    void updateEntityFromFullDTO(GroupeFullDTO fullDTO, @MappingTarget Groupe entity);
}
