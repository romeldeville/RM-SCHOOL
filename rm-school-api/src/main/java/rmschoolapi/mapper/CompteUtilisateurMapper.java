package rmschoolapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import rmschoolapi.dto.basic.CompteUtilisateurBasicDTO;
import rmschoolapi.dto.full.CompteUtilisateurFullDTO;
import rmschoolapi.entity.CompteUtilisateur;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompteUtilisateurMapper {

    CompteUtilisateurBasicDTO toBasicDTO(CompteUtilisateur entity);

    List<CompteUtilisateurBasicDTO> toBasicDTOList(List<CompteUtilisateur> entities);

    CompteUtilisateur toEntity(CompteUtilisateurBasicDTO basicDTO);

    List<CompteUtilisateur> toEntityFromBasicList(List<CompteUtilisateurBasicDTO> basicDTOs);

    CompteUtilisateurFullDTO toFullDTO(CompteUtilisateur entity);

    List<CompteUtilisateurFullDTO> toFullDTOList(List<CompteUtilisateur> entities);

    CompteUtilisateur toEntity(CompteUtilisateurFullDTO fullDTO);

    List<CompteUtilisateur> toEntityFromFullList(List<CompteUtilisateurFullDTO> fullDTOs);

    void updateEntityFromBasicDTO(CompteUtilisateurBasicDTO basicDTO, @MappingTarget CompteUtilisateur entity);

    void updateEntityFromFullDTO(CompteUtilisateurFullDTO fullDTO, @MappingTarget CompteUtilisateur entity);
}
