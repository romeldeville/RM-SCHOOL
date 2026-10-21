package rmschoolapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rmschoolapi.dto.basic.FraisBasicDTO;
import rmschoolapi.dto.full.FraisFullDTO;
import rmschoolapi.entity.Frais;
import rmschoolapi.exception.RessourceIntrouvableException;
import rmschoolapi.mapper.FraisMapper;
import rmschoolapi.repository.FraisRepository;
import rmschoolapi.service.FraisService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class FraisServiceImpl implements FraisService {

    private final FraisRepository repository;
    private final FraisMapper mapper;

    @Override
    public FraisBasicDTO creer(FraisBasicDTO basicDTO) {
        Frais entity = mapper.toEntity(basicDTO);
        Frais sauvegarde = repository.save(entity);
        return mapper.toBasicDTO(sauvegarde);
    }

    @Override
    public FraisFullDTO creerComplet(FraisFullDTO fullDTO) {
        Frais entity = mapper.toEntity(fullDTO);
        Frais sauvegarde = repository.save(entity);
        return mapper.toFullDTO(sauvegarde);
    }

    @Override
    @Transactional(readOnly = true)
    public FraisFullDTO obtenirParId(Long id) {
        Frais entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Frais", id));
        return mapper.toFullDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public FraisBasicDTO obtenirBasicParId(Long id) {
        Frais entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Frais", id));
        return mapper.toBasicDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<FraisFullDTO> obtenirTous() {
        return mapper.toFullDTOList(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<FraisBasicDTO> obtenirTousBasic() {
        return mapper.toBasicDTOList(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Page<FraisFullDTO> obtenirTous(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toFullDTO);
    }

    @Override
    public FraisFullDTO modifier(Long id, FraisFullDTO fullDTO) {
        Frais entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Frais", id));
        mapper.updateEntityFromFullDTO(fullDTO, entity);
        Frais sauvegarde = repository.save(entity);
        return mapper.toFullDTO(sauvegarde);
    }

    @Override
    public FraisBasicDTO modifierBasic(Long id, FraisBasicDTO basicDTO) {
        Frais entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Frais", id));
        mapper.updateEntityFromBasicDTO(basicDTO, entity);
        Frais sauvegarde = repository.save(entity);
        return mapper.toBasicDTO(sauvegarde);
    }

    @Override
    public void supprimer(Long id) {
        if (!repository.existsById(id)) {
            throw new RessourceIntrouvableException("Frais", id);
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
