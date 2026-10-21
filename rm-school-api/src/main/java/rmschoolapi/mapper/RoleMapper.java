package rmschoolapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import rmschoolapi.dto.basic.RoleBasicDTO;
import rmschoolapi.dto.full.RoleFullDTO;
import rmschoolapi.entity.Role;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleBasicDTO toBasicDTO(Role entity);

    List<RoleBasicDTO> toBasicDTOList(List<Role> entities);

    Role toEntity(RoleBasicDTO basicDTO);

    List<Role> toEntityFromBasicList(List<RoleBasicDTO> basicDTOs);

    RoleFullDTO toFullDTO(Role entity);

    List<RoleFullDTO> toFullDTOList(List<Role> entities);

    Role toEntity(RoleFullDTO fullDTO);

    List<Role> toEntityFromFullList(List<RoleFullDTO> fullDTOs);

    void updateEntityFromBasicDTO(RoleBasicDTO basicDTO, @MappingTarget Role entity);

    void updateEntityFromFullDTO(RoleFullDTO fullDTO, @MappingTarget Role entity);
}
