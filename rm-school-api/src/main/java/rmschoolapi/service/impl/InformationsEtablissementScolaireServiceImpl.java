package rmschoolapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rmschoolapi.dto.basic.InformationsEtablissementScolaireBasicDTO;
import rmschoolapi.dto.full.InformationsEtablissementScolaireFullDTO;
import rmschoolapi.entity.InformationsEtablissementScolaire;
import rmschoolapi.exception.RessourceIntrouvableException;
import rmschoolapi.mapper.InformationsEtablissementScolaireMapper;
import rmschoolapi.repository.InformationsEtablissementScolaireRepository;
import rmschoolapi.service.InformationsEtablissementScolaireService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class InformationsEtablissementScolaireServiceImpl implements InformationsEtablissementScolaireService {

    private final InformationsEtablissementScolaireRepository repository;
    private final InformationsEtablissementScolaireMapper mapper;

    @Override
    public InformationsEtablissementScolaireBasicDTO creer(InformationsEtablissementScolaireBasicDTO basicDTO) {
        InformationsEtablissementScolaire entity = mapper.toEntity(basicDTO);
        InformationsEtablissementScolaire sauvegarde = repository.save(entity);
        return mapper.toBasicDTO(sauvegarde);
    }

    @Override
    public InformationsEtablissementScolaireFullDTO creerComplet(InformationsEtablissementScolaireFullDTO fullDTO) {
        InformationsEtablissementScolaire entity = mapper.toEntity(fullDTO);
        InformationsEtablissementScolaire sauvegarde = repository.save(entity);
        return mapper.toFullDTO(sauvegarde);
    }

    @Override
    @Transactional(readOnly = true)
    public InformationsEtablissementScolaireFullDTO obtenirParId(Long id) {
        InformationsEtablissementScolaire entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("InformationsEtablissementScolaire", id));
        return mapper.toFullDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public InformationsEtablissementScolaireBasicDTO obtenirBasicParId(Long id) {
        InformationsEtablissementScolaire entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("InformationsEtablissementScolaire", id));
        return mapper.toBasicDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<InformationsEtablissementScolaireFullDTO> obtenirTous() {
        return mapper.toFullDTOList(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<InformationsEtablissementScolaireBasicDTO> obtenirTousBasic() {
        return mapper.toBasicDTOList(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Page<InformationsEtablissementScolaireFullDTO> obtenirTous(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toFullDTO);
    }

    @Override
    public InformationsEtablissementScolaireFullDTO modifier(Long id, InformationsEtablissementScolaireFullDTO fullDTO) {
        InformationsEtablissementScolaire entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("InformationsEtablissementScolaire", id));
        mapper.updateEntityFromFullDTO(fullDTO, entity);
        InformationsEtablissementScolaire sauvegarde = repository.save(entity);
        return mapper.toFullDTO(sauvegarde);
    }

    @Override
    public InformationsEtablissementScolaireBasicDTO modifierBasic(Long id, InformationsEtablissementScolaireBasicDTO basicDTO) {
        InformationsEtablissementScolaire entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("InformationsEtablissementScolaire", id));
        mapper.updateEntityFromBasicDTO(basicDTO, entity);
        InformationsEtablissementScolaire sauvegarde = repository.save(entity);
        return mapper.toBasicDTO(sauvegarde);
    }

    @Override
    public void supprimer(Long id) {
        if (!repository.existsById(id)) {
            throw new RessourceIntrouvableException("InformationsEtablissementScolaire", id);
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
