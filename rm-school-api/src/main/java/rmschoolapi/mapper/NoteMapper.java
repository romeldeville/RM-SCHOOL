package rmschoolapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import rmschoolapi.dto.basic.NoteBasicDTO;
import rmschoolapi.dto.full.NoteFullDTO;
import rmschoolapi.entity.Note;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NoteMapper {

    NoteBasicDTO toBasicDTO(Note entity);

    List<NoteBasicDTO> toBasicDTOList(List<Note> entities);

    Note toEntity(NoteBasicDTO basicDTO);

    List<Note> toEntityFromBasicList(List<NoteBasicDTO> basicDTOs);

    NoteFullDTO toFullDTO(Note entity);

    List<NoteFullDTO> toFullDTOList(List<Note> entities);

    Note toEntity(NoteFullDTO fullDTO);

    List<Note> toEntityFromFullList(List<NoteFullDTO> fullDTOs);

    void updateEntityFromBasicDTO(NoteBasicDTO basicDTO, @MappingTarget Note entity);

    void updateEntityFromFullDTO(NoteFullDTO fullDTO, @MappingTarget Note entity);
}
