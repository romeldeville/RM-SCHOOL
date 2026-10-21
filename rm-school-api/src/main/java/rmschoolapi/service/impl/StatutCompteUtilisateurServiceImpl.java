package rmschoolapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rmschoolapi.dto.basic.StatutCompteUtilisateurBasicDTO;
import rmschoolapi.dto.full.StatutCompteUtilisateurFullDTO;
import rmschoolapi.entity.StatutCompteUtilisateur;
import rmschoolapi.exception.RessourceIntrouvableException;
import rmschoolapi.mapper.StatutCompteUtilisateurMapper;
import rmschoolapi.repository.StatutCompteUtilisateurRepository;
import rmschoolapi.service.StatutCompteUtilisateurService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class StatutCompteUtilisateurServiceImpl implements StatutCompteUtilisateurService {

    private final StatutCompteUtilisateurRepository repository;
    private final StatutCompteUtilisateurMapper mapper;

    @Override
    public StatutCompteUtilisateurBasicDTO creer(StatutCompteUtilisateurBasicDTO basicDTO) {
        StatutCompteUtilisateur entity = mapper.toEntity(basicDTO);
        StatutCompteUtilisateur sauvegarde = repository.save(entity);
        return mapper.toBasicDTO(sauvegarde);
    }

    @Override
    public StatutCompteUtilisateurFullDTO creerComplet(StatutCompteUtilisateurFullDTO fullDTO) {
        StatutCompteUtilisateur entity = mapper.toEntity(fullDTO);
        StatutCompteUtilisateur sauvegarde = repository.save(entity);
        return mapper.toFullDTO(sauvegarde);
    }

    @Override
    @Transactional(readOnly = true)
    public StatutCompteUtilisateurFullDTO obtenirParId(Long id) {
        StatutCompteUtilisateur entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("StatutCompteUtilisateur", id));
        return mapper.toFullDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public StatutCompteUtilisateurBasicDTO obtenirBasicParId(Long id) {
        StatutCompteUtilisateur entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("StatutCompteUtilisateur", id));
        return mapper.toBasicDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<StatutCompteUtilisateurFullDTO> obtenirTous() {
        return mapper.toFullDTOList(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<StatutCompteUtilisateurBasicDTO> obtenirTousBasic() {
        return mapper.toBasicDTOList(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Page<StatutCompteUtilisateurFullDTO> obtenirTous(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toFullDTO);
    }

    @Override
    public StatutCompteUtilisateurFullDTO modifier(Long id, StatutCompteUtilisateurFullDTO fullDTO) {
        StatutCompteUtilisateur entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("StatutCompteUtilisateur", id));
        mapper.updateEntityFromFullDTO(fullDTO, entity);
        StatutCompteUtilisateur sauvegarde = repository.save(entity);
        return mapper.toFullDTO(sauvegarde);
    }

    @Override
    public StatutCompteUtilisateurBasicDTO modifierBasic(Long id, StatutCompteUtilisateurBasicDTO basicDTO) {
        StatutCompteUtilisateur entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("StatutCompteUtilisateur", id));
        mapper.updateEntityFromBasicDTO(basicDTO, entity);
        StatutCompteUtilisateur sauvegarde = repository.save(entity);
        return mapper.toBasicDTO(sauvegarde);
    }

    @Override
    public void supprimer(Long id) {
        if (!repository.existsById(id)) {
            throw new RessourceIntrouvableException("StatutCompteUtilisateur", id);
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
