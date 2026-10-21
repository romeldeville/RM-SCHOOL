package rmschoolapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rmschoolapi.dto.basic.CourNiveauBasicDTO;
import rmschoolapi.dto.full.CourNiveauFullDTO;
import rmschoolapi.entity.CourNiveau;
import rmschoolapi.exception.RessourceIntrouvableException;
import rmschoolapi.mapper.CourNiveauMapper;
import rmschoolapi.repository.CourNiveauRepository;
import rmschoolapi.service.CourNiveauService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CourNiveauServiceImpl implements CourNiveauService {

    private final CourNiveauRepository repository;
    private final CourNiveauMapper mapper;

    @Override
    public CourNiveauBasicDTO creer(CourNiveauBasicDTO basicDTO) {
        CourNiveau entity = mapper.toEntity(basicDTO);
        CourNiveau sauvegarde = repository.save(entity);
        return mapper.toBasicDTO(sauvegarde);
    }

    @Override
    public CourNiveauFullDTO creerComplet(CourNiveauFullDTO fullDTO) {
        CourNiveau entity = mapper.toEntity(fullDTO);
        CourNiveau sauvegarde = repository.save(entity);
        return mapper.toFullDTO(sauvegarde);
    }

    @Override
    @Transactional(readOnly = true)
    public CourNiveauFullDTO obtenirParId(Long id) {
        CourNiveau entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("CourNiveau", id));
        return mapper.toFullDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public CourNiveauBasicDTO obtenirBasicParId(Long id) {
        CourNiveau entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("CourNiveau", id));
        return mapper.toBasicDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CourNiveauFullDTO> obtenirTous() {
        return mapper.toFullDTOList(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<CourNiveauBasicDTO> obtenirTousBasic() {
        return mapper.toBasicDTOList(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Page<CourNiveauFullDTO> obtenirTous(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toFullDTO);
    }

    @Override
    public CourNiveauFullDTO modifier(Long id, CourNiveauFullDTO fullDTO) {
        CourNiveau entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("CourNiveau", id));
        mapper.updateEntityFromFullDTO(fullDTO, entity);
        CourNiveau sauvegarde = repository.save(entity);
        return mapper.toFullDTO(sauvegarde);
    }

    @Override
    public CourNiveauBasicDTO modifierBasic(Long id, CourNiveauBasicDTO basicDTO) {
        CourNiveau entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("CourNiveau", id));
        mapper.updateEntityFromBasicDTO(basicDTO, entity);
        CourNiveau sauvegarde = repository.save(entity);
        return mapper.toBasicDTO(sauvegarde);
    }

    @Override
    public void supprimer(Long id) {
        if (!repository.existsById(id)) {
            throw new RessourceIntrouvableException("CourNiveau", id);
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
