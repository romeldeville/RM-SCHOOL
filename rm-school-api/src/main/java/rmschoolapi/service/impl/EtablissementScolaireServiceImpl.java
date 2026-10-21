package rmschoolapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rmschoolapi.dto.basic.EtablissementScolaireBasicDTO;
import rmschoolapi.dto.full.EtablissementScolaireFullDTO;
import rmschoolapi.entity.EtablissementScolaire;
import rmschoolapi.exception.RessourceIntrouvableException;
import rmschoolapi.mapper.EtablissementScolaireMapper;
import rmschoolapi.repository.EtablissementScolaireRepository;
import rmschoolapi.service.EtablissementScolaireService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class EtablissementScolaireServiceImpl implements EtablissementScolaireService {

    private final EtablissementScolaireRepository repository;
    private final EtablissementScolaireMapper mapper;

    @Override
    public EtablissementScolaireBasicDTO creer(EtablissementScolaireBasicDTO basicDTO) {
        EtablissementScolaire entity = mapper.toEntity(basicDTO);
        EtablissementScolaire sauvegarde = repository.save(entity);
        return mapper.toBasicDTO(sauvegarde);
    }

    @Override
    public EtablissementScolaireFullDTO creerComplet(EtablissementScolaireFullDTO fullDTO) {
        EtablissementScolaire entity = mapper.toEntity(fullDTO);
        EtablissementScolaire sauvegarde = repository.save(entity);
        return mapper.toFullDTO(sauvegarde);
    }

    @Override
    @Transactional(readOnly = true)
    public EtablissementScolaireFullDTO obtenirParId(Long id) {
        EtablissementScolaire entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("EtablissementScolaire", id));
        return mapper.toFullDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public EtablissementScolaireBasicDTO obtenirBasicParId(Long id) {
        EtablissementScolaire entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("EtablissementScolaire", id));
        return mapper.toBasicDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<EtablissementScolaireFullDTO> obtenirTous() {
        return mapper.toFullDTOList(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<EtablissementScolaireBasicDTO> obtenirTousBasic() {
        return mapper.toBasicDTOList(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Page<EtablissementScolaireFullDTO> obtenirTous(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toFullDTO);
    }

    @Override
    public EtablissementScolaireFullDTO modifier(Long id, EtablissementScolaireFullDTO fullDTO) {
        EtablissementScolaire entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("EtablissementScolaire", id));
        mapper.updateEntityFromFullDTO(fullDTO, entity);
        EtablissementScolaire sauvegarde = repository.save(entity);
        return mapper.toFullDTO(sauvegarde);
    }

    @Override
    public EtablissementScolaireBasicDTO modifierBasic(Long id, EtablissementScolaireBasicDTO basicDTO) {
        EtablissementScolaire entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("EtablissementScolaire", id));
        mapper.updateEntityFromBasicDTO(basicDTO, entity);
        EtablissementScolaire sauvegarde = repository.save(entity);
        return mapper.toBasicDTO(sauvegarde);
    }

    @Override
    public void supprimer(Long id) {
        if (!repository.existsById(id)) {
            throw new RessourceIntrouvableException("EtablissementScolaire", id);
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
