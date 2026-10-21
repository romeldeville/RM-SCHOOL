package rmschoolapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rmschoolapi.dto.basic.ParametreBasicDTO;
import rmschoolapi.dto.full.ParametreFullDTO;
import rmschoolapi.entity.Parametre;
import rmschoolapi.exception.RessourceIntrouvableException;
import rmschoolapi.mapper.ParametreMapper;
import rmschoolapi.repository.ParametreRepository;
import rmschoolapi.service.ParametreService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ParametreServiceImpl implements ParametreService {

    private final ParametreRepository repository;
    private final ParametreMapper mapper;

    @Override
    public ParametreBasicDTO creer(ParametreBasicDTO basicDTO) {
        Parametre entity = mapper.toEntity(basicDTO);
        Parametre sauvegarde = repository.save(entity);
        return mapper.toBasicDTO(sauvegarde);
    }

    @Override
    public ParametreFullDTO creerComplet(ParametreFullDTO fullDTO) {
        Parametre entity = mapper.toEntity(fullDTO);
        Parametre sauvegarde = repository.save(entity);
        return mapper.toFullDTO(sauvegarde);
    }

    @Override
    @Transactional(readOnly = true)
    public ParametreFullDTO obtenirParId(Long id) {
        Parametre entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Parametre", id));
        return mapper.toFullDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public ParametreBasicDTO obtenirBasicParId(Long id) {
        Parametre entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Parametre", id));
        return mapper.toBasicDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ParametreFullDTO> obtenirTous() {
        return mapper.toFullDTOList(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ParametreBasicDTO> obtenirTousBasic() {
        return mapper.toBasicDTOList(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ParametreFullDTO> obtenirTous(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toFullDTO);
    }

    @Override
    public ParametreFullDTO modifier(Long id, ParametreFullDTO fullDTO) {
        Parametre entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Parametre", id));
        mapper.updateEntityFromFullDTO(fullDTO, entity);
        Parametre sauvegarde = repository.save(entity);
        return mapper.toFullDTO(sauvegarde);
    }

    @Override
    public ParametreBasicDTO modifierBasic(Long id, ParametreBasicDTO basicDTO) {
        Parametre entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Parametre", id));
        mapper.updateEntityFromBasicDTO(basicDTO, entity);
        Parametre sauvegarde = repository.save(entity);
        return mapper.toBasicDTO(sauvegarde);
    }

    @Override
    public void supprimer(Long id) {
        if (!repository.existsById(id)) {
            throw new RessourceIntrouvableException("Parametre", id);
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
