package rmschoolapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import rmschoolapi.dto.basic.InscriptionBasicDTO;
import rmschoolapi.dto.full.InscriptionFullDTO;
import rmschoolapi.entity.Inscription;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InscriptionMapper {

    InscriptionBasicDTO toBasicDTO(Inscription entity);

    List<InscriptionBasicDTO> toBasicDTOList(List<Inscription> entities);

    Inscription toEntity(InscriptionBasicDTO basicDTO);

    List<Inscription> toEntityFromBasicList(List<InscriptionBasicDTO> basicDTOs);

    InscriptionFullDTO toFullDTO(Inscription entity);

    List<InscriptionFullDTO> toFullDTOList(List<Inscription> entities);

    Inscription toEntity(InscriptionFullDTO fullDTO);

    List<Inscription> toEntityFromFullList(List<InscriptionFullDTO> fullDTOs);

    void updateEntityFromBasicDTO(InscriptionBasicDTO basicDTO, @MappingTarget Inscription entity);

    void updateEntityFromFullDTO(InscriptionFullDTO fullDTO, @MappingTarget Inscription entity);
}
