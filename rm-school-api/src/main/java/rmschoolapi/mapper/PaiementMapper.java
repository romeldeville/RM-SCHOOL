package rmschoolapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import rmschoolapi.dto.basic.PaiementBasicDTO;
import rmschoolapi.dto.full.PaiementFullDTO;
import rmschoolapi.entity.Paiement;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PaiementMapper {

    PaiementBasicDTO toBasicDTO(Paiement entity);

    List<PaiementBasicDTO> toBasicDTOList(List<Paiement> entities);

    Paiement toEntity(PaiementBasicDTO basicDTO);

    List<Paiement> toEntityFromBasicList(List<PaiementBasicDTO> basicDTOs);

    PaiementFullDTO toFullDTO(Paiement entity);

    List<PaiementFullDTO> toFullDTOList(List<Paiement> entities);

    Paiement toEntity(PaiementFullDTO fullDTO);

    List<Paiement> toEntityFromFullList(List<PaiementFullDTO> fullDTOs);

    void updateEntityFromBasicDTO(PaiementBasicDTO basicDTO, @MappingTarget Paiement entity);

    void updateEntityFromFullDTO(PaiementFullDTO fullDTO, @MappingTarget Paiement entity);
}
