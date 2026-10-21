package rmschoolapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rmschoolapi.dto.basic.NoteBasicDTO;
import rmschoolapi.dto.full.NoteFullDTO;
import rmschoolapi.entity.Note;
import rmschoolapi.exception.RessourceIntrouvableException;
import rmschoolapi.mapper.NoteMapper;
import rmschoolapi.repository.NoteRepository;
import rmschoolapi.service.NoteService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class NoteServiceImpl implements NoteService {

    private final NoteRepository repository;
    private final NoteMapper mapper;

    @Override
    public NoteBasicDTO creer(NoteBasicDTO basicDTO) {
        Note entity = mapper.toEntity(basicDTO);
        Note sauvegarde = repository.save(entity);
        return mapper.toBasicDTO(sauvegarde);
    }

    @Override
    public NoteFullDTO creerComplet(NoteFullDTO fullDTO) {
        Note entity = mapper.toEntity(fullDTO);
        Note sauvegarde = repository.save(entity);
        return mapper.toFullDTO(sauvegarde);
    }

    @Override
    @Transactional(readOnly = true)
    public NoteFullDTO obtenirParId(Long id) {
        Note entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Note", id));
        return mapper.toFullDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public NoteBasicDTO obtenirBasicParId(Long id) {
        Note entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Note", id));
        return mapper.toBasicDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<NoteFullDTO> obtenirTous() {
        return mapper.toFullDTOList(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<NoteBasicDTO> obtenirTousBasic() {
        return mapper.toBasicDTOList(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Page<NoteFullDTO> obtenirTous(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toFullDTO);
    }

    @Override
    public NoteFullDTO modifier(Long id, NoteFullDTO fullDTO) {
        Note entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Note", id));
        mapper.updateEntityFromFullDTO(fullDTO, entity);
        Note sauvegarde = repository.save(entity);
        return mapper.toFullDTO(sauvegarde);
    }

    @Override
    public NoteBasicDTO modifierBasic(Long id, NoteBasicDTO basicDTO) {
        Note entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Note", id));
        mapper.updateEntityFromBasicDTO(basicDTO, entity);
        Note sauvegarde = repository.save(entity);
        return mapper.toBasicDTO(sauvegarde);
    }

    @Override
    public void supprimer(Long id) {
        if (!repository.existsById(id)) {
            throw new RessourceIntrouvableException("Note", id);
        }
        repository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existe(Long id) {
        return repository.existsById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public long compter() {
        return repository.count();
    }
}
