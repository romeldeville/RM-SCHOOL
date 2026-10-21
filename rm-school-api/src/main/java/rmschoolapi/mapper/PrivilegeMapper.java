package rmschoolapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import rmschoolapi.dto.basic.PrivilegeBasicDTO;
import rmschoolapi.dto.full.PrivilegeFullDTO;
import rmschoolapi.entity.Privilege;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PrivilegeMapper {

    PrivilegeBasicDTO toBasicDTO(Privilege entity);

    List<PrivilegeBasicDTO> toBasicDTOList(List<Privilege> entities);

    Privilege toEntity(PrivilegeBasicDTO basicDTO);

    List<Privilege> toEntityFromBasicList(List<PrivilegeBasicDTO> basicDTOs);

    PrivilegeFullDTO toFullDTO(Privilege entity);

    List<PrivilegeFullDTO> toFullDTOList(List<Privilege> entities);

    Privilege toEntity(PrivilegeFullDTO fullDTO);

    List<Privilege> toEntityFromFullList(List<PrivilegeFullDTO> fullDTOs);

    void updateEntityFromBasicDTO(PrivilegeBasicDTO basicDTO, @MappingTarget Privilege entity);

    void updateEntityFromFullDTO(PrivilegeFullDTO fullDTO, @MappingTarget Privilege entity);
}
