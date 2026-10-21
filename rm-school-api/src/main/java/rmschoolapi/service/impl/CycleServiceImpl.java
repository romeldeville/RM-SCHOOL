package rmschoolapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rmschoolapi.dto.basic.CycleBasicDTO;
import rmschoolapi.dto.full.CycleFullDTO;
import rmschoolapi.entity.Cycle;
import rmschoolapi.exception.RessourceIntrouvableException;
import rmschoolapi.mapper.CycleMapper;
import rmschoolapi.repository.CycleRepository;
import rmschoolapi.service.CycleService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CycleServiceImpl implements CycleService {

    private final CycleRepository repository;
    private final CycleMapper mapper;

    @Override
    public CycleBasicDTO creer(CycleBasicDTO basicDTO) {
        Cycle entity = mapper.toEntity(basicDTO);
        Cycle sauvegarde = repository.save(entity);
        return mapper.toBasicDTO(sauvegarde);
    }

    @Override
    public CycleFullDTO creerComplet(CycleFullDTO fullDTO) {
        Cycle entity = mapper.toEntity(fullDTO);
        Cycle sauvegarde = repository.save(entity);
        return mapper.toFullDTO(sauvegarde);
    }

    @Override
    @Transactional(readOnly = true)
    public CycleFullDTO obtenirParId(Long id) {
        Cycle entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Cycle", id));
        return mapper.toFullDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public CycleBasicDTO obtenirBasicParId(Long id) {
        Cycle entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Cycle", id));
        return mapper.toBasicDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CycleFullDTO> obtenirTous() {
        return mapper.toFullDTOList(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<CycleBasicDTO> obtenirTousBasic() {
        return mapper.toBasicDTOList(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Page<CycleFullDTO> obtenirTous(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toFullDTO);
    }

    @Override
    public CycleFullDTO modifier(Long id, CycleFullDTO fullDTO) {
        Cycle entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Cycle", id));
        mapper.updateEntityFromFullDTO(fullDTO, entity);
        Cycle sauvegarde = repository.save(entity);
        return mapper.toFullDTO(sauvegarde);
    }

    @Override
    public CycleBasicDTO modifierBasic(Long id, CycleBasicDTO basicDTO) {
        Cycle entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Cycle", id));
        mapper.updateEntityFromBasicDTO(basicDTO, entity);
        Cycle sauvegarde = repository.save(entity);
        return mapper.toBasicDTO(sauvegarde);
    }

    @Override
    public void supprimer(Long id) {
        if (!repository.existsById(id)) {
            throw new RessourceIntrouvableException("Cycle", id);
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
