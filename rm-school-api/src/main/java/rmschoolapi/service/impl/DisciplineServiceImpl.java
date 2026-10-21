package rmschoolapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rmschoolapi.dto.basic.DisciplineBasicDTO;
import rmschoolapi.dto.full.DisciplineFullDTO;
import rmschoolapi.entity.Discipline;
import rmschoolapi.exception.RessourceIntrouvableException;
import rmschoolapi.mapper.DisciplineMapper;
import rmschoolapi.repository.DisciplineRepository;
import rmschoolapi.service.DisciplineService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class DisciplineServiceImpl implements DisciplineService {

    private final DisciplineRepository repository;
    private final DisciplineMapper mapper;

    @Override
    public DisciplineBasicDTO creer(DisciplineBasicDTO basicDTO) {
        Discipline entity = mapper.toEntity(basicDTO);
        Discipline sauvegarde = repository.save(entity);
        return mapper.toBasicDTO(sauvegarde);
    }

    @Override
    public DisciplineFullDTO creerComplet(DisciplineFullDTO fullDTO) {
        Discipline entity = mapper.toEntity(fullDTO);
        Discipline sauvegarde = repository.save(entity);
        return mapper.toFullDTO(sauvegarde);
    }

    @Override
    @Transactional(readOnly = true)
    public DisciplineFullDTO obtenirParId(Long id) {
        Discipline entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Discipline", id));
        return mapper.toFullDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public DisciplineBasicDTO obtenirBasicParId(Long id) {
        Discipline entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Discipline", id));
        return mapper.toBasicDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DisciplineFullDTO> obtenirTous() {
        return mapper.toFullDTOList(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<DisciplineBasicDTO> obtenirTousBasic() {
        return mapper.toBasicDTOList(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Page<DisciplineFullDTO> obtenirTous(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toFullDTO);
    }

    @Override
    public DisciplineFullDTO modifier(Long id, DisciplineFullDTO fullDTO) {
        Discipline entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Discipline", id));
        mapper.updateEntityFromFullDTO(fullDTO, entity);
        Discipline sauvegarde = repository.save(entity);
        return mapper.toFullDTO(sauvegarde);
    }

    @Override
    public DisciplineBasicDTO modifierBasic(Long id, DisciplineBasicDTO basicDTO) {
        Discipline entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Discipline", id));
        mapper.updateEntityFromBasicDTO(basicDTO, entity);
        Discipline sauvegarde = repository.save(entity);
        return mapper.toBasicDTO(sauvegarde);
    }

    @Override
    public void supprimer(Long id) {
        if (!repository.existsById(id)) {
            throw new RessourceIntrouvableException("Discipline", id);
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
