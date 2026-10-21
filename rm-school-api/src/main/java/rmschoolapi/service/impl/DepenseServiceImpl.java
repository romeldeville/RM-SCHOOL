package rmschoolapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rmschoolapi.dto.basic.DepenseBasicDTO;
import rmschoolapi.dto.full.DepenseFullDTO;
import rmschoolapi.entity.Depense;
import rmschoolapi.exception.RessourceIntrouvableException;
import rmschoolapi.mapper.DepenseMapper;
import rmschoolapi.repository.DepenseRepository;
import rmschoolapi.service.DepenseService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class DepenseServiceImpl implements DepenseService {

    private final DepenseRepository repository;
    private final DepenseMapper mapper;

    @Override
    public DepenseBasicDTO creer(DepenseBasicDTO basicDTO) {
        Depense entity = mapper.toEntity(basicDTO);
        Depense sauvegarde = repository.save(entity);
        return mapper.toBasicDTO(sauvegarde);
    }

    @Override
    public DepenseFullDTO creerComplet(DepenseFullDTO fullDTO) {
        Depense entity = mapper.toEntity(fullDTO);
        Depense sauvegarde = repository.save(entity);
        return mapper.toFullDTO(sauvegarde);
    }

    @Override
    @Transactional(readOnly = true)
    public DepenseFullDTO obtenirParId(Long id) {
        Depense entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Depense", id));
        return mapper.toFullDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public DepenseBasicDTO obtenirBasicParId(Long id) {
        Depense entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Depense", id));
        return mapper.toBasicDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DepenseFullDTO> obtenirTous() {
        return mapper.toFullDTOList(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<DepenseBasicDTO> obtenirTousBasic() {
        return mapper.toBasicDTOList(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Page<DepenseFullDTO> obtenirTous(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toFullDTO);
    }

    @Override
    public DepenseFullDTO modifier(Long id, DepenseFullDTO fullDTO) {
        Depense entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Depense", id));
        mapper.updateEntityFromFullDTO(fullDTO, entity);
        Depense sauvegarde = repository.save(entity);
        return mapper.toFullDTO(sauvegarde);
    }

    @Override
    public DepenseBasicDTO modifierBasic(Long id, DepenseBasicDTO basicDTO) {
        Depense entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Depense", id));
        mapper.updateEntityFromBasicDTO(basicDTO, entity);
        Depense sauvegarde = repository.save(entity);
        return mapper.toBasicDTO(sauvegarde);
    }

    @Override
    public void supprimer(Long id) {
        if (!repository.existsById(id)) {
            throw new RessourceIntrouvableException("Depense", id);
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
