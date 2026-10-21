package rmschoolapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rmschoolapi.dto.basic.CoursEnseignantBasicDTO;
import rmschoolapi.dto.full.CoursEnseignantFullDTO;
import rmschoolapi.entity.CoursEnseignant;
import rmschoolapi.exception.RessourceIntrouvableException;
import rmschoolapi.mapper.CoursEnseignantMapper;
import rmschoolapi.repository.CoursEnseignantRepository;
import rmschoolapi.service.CoursEnseignantService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CoursEnseignantServiceImpl implements CoursEnseignantService {

    private final CoursEnseignantRepository repository;
    private final CoursEnseignantMapper mapper;

    @Override
    public CoursEnseignantBasicDTO creer(CoursEnseignantBasicDTO basicDTO) {
        CoursEnseignant entity = mapper.toEntity(basicDTO);
        CoursEnseignant sauvegarde = repository.save(entity);
        return mapper.toBasicDTO(sauvegarde);
    }

    @Override
    public CoursEnseignantFullDTO creerComplet(CoursEnseignantFullDTO fullDTO) {
        CoursEnseignant entity = mapper.toEntity(fullDTO);
        CoursEnseignant sauvegarde = repository.save(entity);
        return mapper.toFullDTO(sauvegarde);
    }

    @Override
    @Transactional(readOnly = true)
    public CoursEnseignantFullDTO obtenirParId(Long id) {
        CoursEnseignant entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("CoursEnseignant", id));
        return mapper.toFullDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public CoursEnseignantBasicDTO obtenirBasicParId(Long id) {
        CoursEnseignant entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("CoursEnseignant", id));
        return mapper.toBasicDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CoursEnseignantFullDTO> obtenirTous() {
        return mapper.toFullDTOList(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<CoursEnseignantBasicDTO> obtenirTousBasic() {
        return mapper.toBasicDTOList(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Page<CoursEnseignantFullDTO> obtenirTous(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toFullDTO);
    }

    @Override
    public CoursEnseignantFullDTO modifier(Long id, CoursEnseignantFullDTO fullDTO) {
        CoursEnseignant entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("CoursEnseignant", id));
        mapper.updateEntityFromFullDTO(fullDTO, entity);
        CoursEnseignant sauvegarde = repository.save(entity);
        return mapper.toFullDTO(sauvegarde);
    }

    @Override
    public CoursEnseignantBasicDTO modifierBasic(Long id, CoursEnseignantBasicDTO basicDTO) {
        CoursEnseignant entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("CoursEnseignant", id));
        mapper.updateEntityFromBasicDTO(basicDTO, entity);
        CoursEnseignant sauvegarde = repository.save(entity);
        return mapper.toBasicDTO(sauvegarde);
    }

    @Override
    public void supprimer(Long id) {
        if (!repository.existsById(id)) {
            throw new RessourceIntrouvableException("CoursEnseignant", id);
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
