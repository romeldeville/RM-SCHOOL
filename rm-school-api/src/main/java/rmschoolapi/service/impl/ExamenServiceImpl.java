package rmschoolapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rmschoolapi.dto.basic.ExamenBasicDTO;
import rmschoolapi.dto.full.ExamenFullDTO;
import rmschoolapi.entity.Examen;
import rmschoolapi.exception.RessourceIntrouvableException;
import rmschoolapi.mapper.ExamenMapper;
import rmschoolapi.repository.ExamenRepository;
import rmschoolapi.service.ExamenService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ExamenServiceImpl implements ExamenService {

    private final ExamenRepository repository;
    private final ExamenMapper mapper;

    @Override
    public ExamenBasicDTO creer(ExamenBasicDTO basicDTO) {
        Examen entity = mapper.toEntity(basicDTO);
        Examen sauvegarde = repository.save(entity);
        return mapper.toBasicDTO(sauvegarde);
    }

    @Override
    public ExamenFullDTO creerComplet(ExamenFullDTO fullDTO) {
        Examen entity = mapper.toEntity(fullDTO);
        Examen sauvegarde = repository.save(entity);
        return mapper.toFullDTO(sauvegarde);
    }

    @Override
    @Transactional(readOnly = true)
    public ExamenFullDTO obtenirParId(Long id) {
        Examen entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Examen", id));
        return mapper.toFullDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public ExamenBasicDTO obtenirBasicParId(Long id) {
        Examen entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Examen", id));
        return mapper.toBasicDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ExamenFullDTO> obtenirTous() {
        return mapper.toFullDTOList(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ExamenBasicDTO> obtenirTousBasic() {
        return mapper.toBasicDTOList(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ExamenFullDTO> obtenirTous(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toFullDTO);
    }

    @Override
    public ExamenFullDTO modifier(Long id, ExamenFullDTO fullDTO) {
        Examen entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Examen", id));
        mapper.updateEntityFromFullDTO(fullDTO, entity);
        Examen sauvegarde = repository.save(entity);
        return mapper.toFullDTO(sauvegarde);
    }

    @Override
    public ExamenBasicDTO modifierBasic(Long id, ExamenBasicDTO basicDTO) {
        Examen entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Examen", id));
        mapper.updateEntityFromBasicDTO(basicDTO, entity);
        Examen sauvegarde = repository.save(entity);
        return mapper.toBasicDTO(sauvegarde);
    }

    @Override
    public void supprimer(Long id) {
        if (!repository.existsById(id)) {
            throw new RessourceIntrouvableException("Examen", id);
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
