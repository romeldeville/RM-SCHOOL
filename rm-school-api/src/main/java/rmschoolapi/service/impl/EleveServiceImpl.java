package rmschoolapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rmschoolapi.dto.basic.EleveBasicDTO;
import rmschoolapi.dto.full.EleveFullDTO;
import rmschoolapi.entity.Eleve;
import rmschoolapi.exception.RessourceIntrouvableException;
import rmschoolapi.mapper.EleveMapper;
import rmschoolapi.repository.EleveRepository;
import rmschoolapi.service.EleveService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class EleveServiceImpl implements EleveService {

    private final EleveRepository repository;
    private final EleveMapper mapper;

    @Override
    public EleveBasicDTO creer(EleveBasicDTO basicDTO) {
        Eleve entity = mapper.toEntity(basicDTO);
        Eleve sauvegarde = repository.save(entity);
        return mapper.toBasicDTO(sauvegarde);
    }

    @Override
    public EleveFullDTO creerComplet(EleveFullDTO fullDTO) {
        Eleve entity = mapper.toEntity(fullDTO);
        Eleve sauvegarde = repository.save(entity);
        return mapper.toFullDTO(sauvegarde);
    }

    @Override
    @Transactional(readOnly = true)
    public EleveFullDTO obtenirParId(Long id) {
        Eleve entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Eleve", id));
        return mapper.toFullDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public EleveBasicDTO obtenirBasicParId(Long id) {
        Eleve entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Eleve", id));
        return mapper.toBasicDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<EleveFullDTO> obtenirTous() {
        return mapper.toFullDTOList(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<EleveBasicDTO> obtenirTousBasic() {
        return mapper.toBasicDTOList(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Page<EleveFullDTO> obtenirTous(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toFullDTO);
    }

    @Override
    public EleveFullDTO modifier(Long id, EleveFullDTO fullDTO) {
        Eleve entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Eleve", id));
        mapper.updateEntityFromFullDTO(fullDTO, entity);
        Eleve sauvegarde = repository.save(entity);
        return mapper.toFullDTO(sauvegarde);
    }

    @Override
    public EleveBasicDTO modifierBasic(Long id, EleveBasicDTO basicDTO) {
        Eleve entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Eleve", id));
        mapper.updateEntityFromBasicDTO(basicDTO, entity);
        Eleve sauvegarde = repository.save(entity);
        return mapper.toBasicDTO(sauvegarde);
    }

    @Override
    public void supprimer(Long id) {
        if (!repository.existsById(id)) {
            throw new RessourceIntrouvableException("Eleve", id);
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
