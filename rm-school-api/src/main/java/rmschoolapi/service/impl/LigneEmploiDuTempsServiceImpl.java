package rmschoolapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rmschoolapi.dto.basic.LigneEmploiDuTempsBasicDTO;
import rmschoolapi.dto.full.LigneEmploiDuTempsFullDTO;
import rmschoolapi.entity.LigneEmploiDuTemps;
import rmschoolapi.exception.RessourceIntrouvableException;
import rmschoolapi.mapper.LigneEmploiDuTempsMapper;
import rmschoolapi.repository.LigneEmploiDuTempsRepository;
import rmschoolapi.service.LigneEmploiDuTempsService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class LigneEmploiDuTempsServiceImpl implements LigneEmploiDuTempsService {

    private final LigneEmploiDuTempsRepository repository;
    private final LigneEmploiDuTempsMapper mapper;

    @Override
    public LigneEmploiDuTempsBasicDTO creer(LigneEmploiDuTempsBasicDTO basicDTO) {
        LigneEmploiDuTemps entity = mapper.toEntity(basicDTO);
        LigneEmploiDuTemps sauvegarde = repository.save(entity);
        return mapper.toBasicDTO(sauvegarde);
    }

    @Override
    public LigneEmploiDuTempsFullDTO creerComplet(LigneEmploiDuTempsFullDTO fullDTO) {
        LigneEmploiDuTemps entity = mapper.toEntity(fullDTO);
        LigneEmploiDuTemps sauvegarde = repository.save(entity);
        return mapper.toFullDTO(sauvegarde);
    }

    @Override
    @Transactional(readOnly = true)
    public LigneEmploiDuTempsFullDTO obtenirParId(Long id) {
        LigneEmploiDuTemps entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("LigneEmploiDuTemps", id));
        return mapper.toFullDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public LigneEmploiDuTempsBasicDTO obtenirBasicParId(Long id) {
        LigneEmploiDuTemps entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("LigneEmploiDuTemps", id));
        return mapper.toBasicDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<LigneEmploiDuTempsFullDTO> obtenirTous() {
        return mapper.toFullDTOList(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<LigneEmploiDuTempsBasicDTO> obtenirTousBasic() {
        return mapper.toBasicDTOList(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Page<LigneEmploiDuTempsFullDTO> obtenirTous(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toFullDTO);
    }

    @Override
    public LigneEmploiDuTempsFullDTO modifier(Long id, LigneEmploiDuTempsFullDTO fullDTO) {
        LigneEmploiDuTemps entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("LigneEmploiDuTemps", id));
        mapper.updateEntityFromFullDTO(fullDTO, entity);
        LigneEmploiDuTemps sauvegarde = repository.save(entity);
        return mapper.toFullDTO(sauvegarde);
    }

    @Override
    public LigneEmploiDuTempsBasicDTO modifierBasic(Long id, LigneEmploiDuTempsBasicDTO basicDTO) {
        LigneEmploiDuTemps entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("LigneEmploiDuTemps", id));
        mapper.updateEntityFromBasicDTO(basicDTO, entity);
        LigneEmploiDuTemps sauvegarde = repository.save(entity);
        return mapper.toBasicDTO(sauvegarde);
    }

    @Override
    public void supprimer(Long id) {
        if (!repository.existsById(id)) {
            throw new RessourceIntrouvableException("LigneEmploiDuTemps", id);
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
