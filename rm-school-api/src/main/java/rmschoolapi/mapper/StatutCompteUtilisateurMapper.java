package rmschoolapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import rmschoolapi.dto.basic.StatutCompteUtilisateurBasicDTO;
import rmschoolapi.dto.full.StatutCompteUtilisateurFullDTO;
import rmschoolapi.entity.StatutCompteUtilisateur;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StatutCompteUtilisateurMapper {

    StatutCompteUtilisateurBasicDTO toBasicDTO(StatutCompteUtilisateur entity);

    List<StatutCompteUtilisateurBasicDTO> toBasicDTOList(List<StatutCompteUtilisateur> entities);

    StatutCompteUtilisateur toEntity(StatutCompteUtilisateurBasicDTO basicDTO);

    List<StatutCompteUtilisateur> toEntityFromBasicList(List<StatutCompteUtilisateurBasicDTO> basicDTOs);

    StatutCompteUtilisateurFullDTO toFullDTO(StatutCompteUtilisateur entity);

    List<StatutCompteUtilisateurFullDTO> toFullDTOList(List<StatutCompteUtilisateur> entities);

    StatutCompteUtilisateur toEntity(StatutCompteUtilisateurFullDTO fullDTO);

    List<StatutCompteUtilisateur> toEntityFromFullList(List<StatutCompteUtilisateurFullDTO> fullDTOs);

    void updateEntityFromBasicDTO(StatutCompteUtilisateurBasicDTO basicDTO, @MappingTarget StatutCompteUtilisateur entity);

    void updateEntityFromFullDTO(StatutCompteUtilisateurFullDTO fullDTO, @MappingTarget StatutCompteUtilisateur entity);
}
