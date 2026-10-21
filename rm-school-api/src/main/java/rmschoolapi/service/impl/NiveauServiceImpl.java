package rmschoolapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rmschoolapi.dto.basic.NiveauBasicDTO;
import rmschoolapi.dto.full.NiveauFullDTO;
import rmschoolapi.entity.Niveau;
import rmschoolapi.exception.RessourceIntrouvableException;
import rmschoolapi.mapper.NiveauMapper;
import rmschoolapi.repository.NiveauRepository;
import rmschoolapi.service.NiveauService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class NiveauServiceImpl implements NiveauService {

    private final NiveauRepository repository;
    private final NiveauMapper mapper;

    @Override
    public NiveauBasicDTO creer(NiveauBasicDTO basicDTO) {
        Niveau entity = mapper.toEntity(basicDTO);
        Niveau sauvegarde = repository.save(entity);
        return mapper.toBasicDTO(sauvegarde);
    }

    @Override
    public NiveauFullDTO creerComplet(NiveauFullDTO fullDTO) {
        Niveau entity = mapper.toEntity(fullDTO);
        Niveau sauvegarde = repository.save(entity);
        return mapper.toFullDTO(sauvegarde);
    }

    @Override
    @Transactional(readOnly = true)
    public NiveauFullDTO obtenirParId(Long id) {
        Niveau entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Niveau", id));
        return mapper.toFullDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public NiveauBasicDTO obtenirBasicParId(Long id) {
        Niveau entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Niveau", id));
        return mapper.toBasicDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<NiveauFullDTO> obtenirTous() {
        return mapper.toFullDTOList(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<NiveauBasicDTO> obtenirTousBasic() {
        return mapper.toBasicDTOList(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Page<NiveauFullDTO> obtenirTous(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toFullDTO);
    }

    @Override
    public NiveauFullDTO modifier(Long id, NiveauFullDTO fullDTO) {
        Niveau entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Niveau", id));
        mapper.updateEntityFromFullDTO(fullDTO, entity);
        Niveau sauvegarde = repository.save(entity);
        return mapper.toFullDTO(sauvegarde);
    }

    @Override
    public NiveauBasicDTO modifierBasic(Long id, NiveauBasicDTO basicDTO) {
        Niveau entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Niveau", id));
        mapper.updateEntityFromBasicDTO(basicDTO, entity);
        Niveau sauvegarde = repository.save(entity);
        return mapper.toBasicDTO(sauvegarde);
    }

    @Override
    public void supprimer(Long id) {
        if (!repository.existsById(id)) {
            throw new RessourceIntrouvableException("Niveau", id);
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
