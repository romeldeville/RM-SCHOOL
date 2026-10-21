package rmschoolapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rmschoolapi.dto.basic.CompteUtilisateurBasicDTO;
import rmschoolapi.dto.full.CompteUtilisateurFullDTO;
import rmschoolapi.entity.CompteUtilisateur;
import rmschoolapi.exception.RessourceIntrouvableException;
import rmschoolapi.mapper.CompteUtilisateurMapper;
import rmschoolapi.repository.CompteUtilisateurRepository;
import rmschoolapi.service.CompteUtilisateurService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CompteUtilisateurServiceImpl implements CompteUtilisateurService {

    private final CompteUtilisateurRepository repository;
    private final CompteUtilisateurMapper mapper;

    @Override
    public CompteUtilisateurBasicDTO creer(CompteUtilisateurBasicDTO basicDTO) {
        CompteUtilisateur entity = mapper.toEntity(basicDTO);
        CompteUtilisateur sauvegarde = repository.save(entity);
        return mapper.toBasicDTO(sauvegarde);
    }

    @Override
    public CompteUtilisateurFullDTO creerComplet(CompteUtilisateurFullDTO fullDTO) {
        CompteUtilisateur entity = mapper.toEntity(fullDTO);
        CompteUtilisateur sauvegarde = repository.save(entity);
        return mapper.toFullDTO(sauvegarde);
    }

    @Override
    @Transactional(readOnly = true)
    public CompteUtilisateurFullDTO obtenirParId(Long id) {
        CompteUtilisateur entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("CompteUtilisateur", id));
        return mapper.toFullDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public CompteUtilisateurBasicDTO obtenirBasicParId(Long id) {
        CompteUtilisateur entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("CompteUtilisateur", id));
        return mapper.toBasicDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CompteUtilisateurFullDTO> obtenirTous() {
        return mapper.toFullDTOList(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<CompteUtilisateurBasicDTO> obtenirTousBasic() {
        return mapper.toBasicDTOList(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Page<CompteUtilisateurFullDTO> obtenirTous(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toFullDTO);
    }

    @Override
    public CompteUtilisateurFullDTO modifier(Long id, CompteUtilisateurFullDTO fullDTO) {
        CompteUtilisateur entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("CompteUtilisateur", id));
        mapper.updateEntityFromFullDTO(fullDTO, entity);
        CompteUtilisateur sauvegarde = repository.save(entity);
        return mapper.toFullDTO(sauvegarde);
    }

    @Override
    public CompteUtilisateurBasicDTO modifierBasic(Long id, CompteUtilisateurBasicDTO basicDTO) {
        CompteUtilisateur entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("CompteUtilisateur", id));
        mapper.updateEntityFromBasicDTO(basicDTO, entity);
        CompteUtilisateur sauvegarde = repository.save(entity);
        return mapper.toBasicDTO(sauvegarde);
    }

    @Override
    public void supprimer(Long id) {
        if (!repository.existsById(id)) {
            throw new RessourceIntrouvableException("CompteUtilisateur", id);
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
