package rmschoolapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rmschoolapi.dto.basic.MatiereBasicDTO;
import rmschoolapi.dto.full.MatiereFullDTO;
import rmschoolapi.entity.Matiere;
import rmschoolapi.exception.RessourceIntrouvableException;
import rmschoolapi.mapper.MatiereMapper;
import rmschoolapi.repository.MatiereRepository;
import rmschoolapi.service.MatiereService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MatiereServiceImpl implements MatiereService {

    private final MatiereRepository repository;
    private final MatiereMapper mapper;

    @Override
    public MatiereBasicDTO creer(MatiereBasicDTO basicDTO) {
        Matiere entity = mapper.toEntity(basicDTO);
        Matiere sauvegarde = repository.save(entity);
        return mapper.toBasicDTO(sauvegarde);
    }

    @Override
    public MatiereFullDTO creerComplet(MatiereFullDTO fullDTO) {
        Matiere entity = mapper.toEntity(fullDTO);
        Matiere sauvegarde = repository.save(entity);
        return mapper.toFullDTO(sauvegarde);
    }

    @Override
    @Transactional(readOnly = true)
    public MatiereFullDTO obtenirParId(Long id) {
        Matiere entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Matiere", id));
        return mapper.toFullDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public MatiereBasicDTO obtenirBasicParId(Long id) {
        Matiere entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Matiere", id));
        return mapper.toBasicDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MatiereFullDTO> obtenirTous() {
        return mapper.toFullDTOList(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<MatiereBasicDTO> obtenirTousBasic() {
        return mapper.toBasicDTOList(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Page<MatiereFullDTO> obtenirTous(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toFullDTO);
    }

    @Override
    public MatiereFullDTO modifier(Long id, MatiereFullDTO fullDTO) {
        Matiere entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Matiere", id));
        mapper.updateEntityFromFullDTO(fullDTO, entity);
        Matiere sauvegarde = repository.save(entity);
        return mapper.toFullDTO(sauvegarde);
    }

    @Override
    public MatiereBasicDTO modifierBasic(Long id, MatiereBasicDTO basicDTO) {
        Matiere entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Matiere", id));
        mapper.updateEntityFromBasicDTO(basicDTO, entity);
        Matiere sauvegarde = repository.save(entity);
        return mapper.toBasicDTO(sauvegarde);
    }

    @Override
    public void supprimer(Long id) {
        if (!repository.existsById(id)) {
            throw new RessourceIntrouvableException("Matiere", id);
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
