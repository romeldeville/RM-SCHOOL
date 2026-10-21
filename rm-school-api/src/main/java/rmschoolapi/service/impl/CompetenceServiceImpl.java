package rmschoolapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rmschoolapi.dto.basic.CompetenceBasicDTO;
import rmschoolapi.dto.full.CompetenceFullDTO;
import rmschoolapi.entity.Competence;
import rmschoolapi.exception.RessourceIntrouvableException;
import rmschoolapi.mapper.CompetenceMapper;
import rmschoolapi.repository.CompetenceRepository;
import rmschoolapi.service.CompetenceService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CompetenceServiceImpl implements CompetenceService {

    private final CompetenceRepository repository;
    private final CompetenceMapper mapper;

    @Override
    public CompetenceBasicDTO creer(CompetenceBasicDTO basicDTO) {
        Competence entity = mapper.toEntity(basicDTO);
        Competence sauvegarde = repository.save(entity);
        return mapper.toBasicDTO(sauvegarde);
    }

    @Override
    public CompetenceFullDTO creerComplet(CompetenceFullDTO fullDTO) {
        Competence entity = mapper.toEntity(fullDTO);
        Competence sauvegarde = repository.save(entity);
        return mapper.toFullDTO(sauvegarde);
    }

    @Override
    @Transactional(readOnly = true)
    public CompetenceFullDTO obtenirParId(Long id) {
        Competence entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Competence", id));
        return mapper.toFullDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public CompetenceBasicDTO obtenirBasicParId(Long id) {
        Competence entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Competence", id));
        return mapper.toBasicDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CompetenceFullDTO> obtenirTous() {
        return mapper.toFullDTOList(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<CompetenceBasicDTO> obtenirTousBasic() {
        return mapper.toBasicDTOList(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Page<CompetenceFullDTO> obtenirTous(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toFullDTO);
    }

    @Override
    public CompetenceFullDTO modifier(Long id, CompetenceFullDTO fullDTO) {
        Competence entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Competence", id));
        mapper.updateEntityFromFullDTO(fullDTO, entity);
        Competence sauvegarde = repository.save(entity);
        return mapper.toFullDTO(sauvegarde);
    }

    @Override
    public CompetenceBasicDTO modifierBasic(Long id, CompetenceBasicDTO basicDTO) {
        Competence entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Competence", id));
        mapper.updateEntityFromBasicDTO(basicDTO, entity);
        Competence sauvegarde = repository.save(entity);
        return mapper.toBasicDTO(sauvegarde);
    }

    @Override
    public void supprimer(Long id) {
        if (!repository.existsById(id)) {
            throw new RessourceIntrouvableException("Competence", id);
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
