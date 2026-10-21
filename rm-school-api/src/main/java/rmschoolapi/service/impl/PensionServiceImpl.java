package rmschoolapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rmschoolapi.dto.basic.PensionBasicDTO;
import rmschoolapi.dto.full.PensionFullDTO;
import rmschoolapi.entity.Pension;
import rmschoolapi.exception.RessourceIntrouvableException;
import rmschoolapi.mapper.PensionMapper;
import rmschoolapi.repository.PensionRepository;
import rmschoolapi.service.PensionService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PensionServiceImpl implements PensionService {

    private final PensionRepository repository;
    private final PensionMapper mapper;

    @Override
    public PensionBasicDTO creer(PensionBasicDTO basicDTO) {
        Pension entity = mapper.toEntity(basicDTO);
        Pension sauvegarde = repository.save(entity);
        return mapper.toBasicDTO(sauvegarde);
    }

    @Override
    public PensionFullDTO creerComplet(PensionFullDTO fullDTO) {
        Pension entity = mapper.toEntity(fullDTO);
        Pension sauvegarde = repository.save(entity);
        return mapper.toFullDTO(sauvegarde);
    }

    @Override
    @Transactional(readOnly = true)
    public PensionFullDTO obtenirParId(Long id) {
        Pension entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Pension", id));
        return mapper.toFullDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public PensionBasicDTO obtenirBasicParId(Long id) {
        Pension entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Pension", id));
        return mapper.toBasicDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PensionFullDTO> obtenirTous() {
        return mapper.toFullDTOList(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<PensionBasicDTO> obtenirTousBasic() {
        return mapper.toBasicDTOList(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Page<PensionFullDTO> obtenirTous(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toFullDTO);
    }

    @Override
    public PensionFullDTO modifier(Long id, PensionFullDTO fullDTO) {
        Pension entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Pension", id));
        mapper.updateEntityFromFullDTO(fullDTO, entity);
        Pension sauvegarde = repository.save(entity);
        return mapper.toFullDTO(sauvegarde);
    }

    @Override
    public PensionBasicDTO modifierBasic(Long id, PensionBasicDTO basicDTO) {
        Pension entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Pension", id));
        mapper.updateEntityFromBasicDTO(basicDTO, entity);
        Pension sauvegarde = repository.save(entity);
        return mapper.toBasicDTO(sauvegarde);
    }

    @Override
    public void supprimer(Long id) {
        if (!repository.existsById(id)) {
            throw new RessourceIntrouvableException("Pension", id);
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
