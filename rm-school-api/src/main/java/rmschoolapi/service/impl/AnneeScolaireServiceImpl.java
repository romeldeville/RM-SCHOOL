package rmschoolapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rmschoolapi.dto.basic.AnneeScolaireBasicDTO;
import rmschoolapi.dto.full.AnneeScolaireFullDTO;
import rmschoolapi.entity.AnneeScolaire;
import rmschoolapi.exception.RessourceIntrouvableException;
import rmschoolapi.mapper.AnneeScolaireMapper;
import rmschoolapi.repository.AnneeScolaireRepository;
import rmschoolapi.service.AnneeScolaireService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AnneeScolaireServiceImpl implements AnneeScolaireService {

    private final AnneeScolaireRepository repository;
    private final AnneeScolaireMapper mapper;

    @Override
    public AnneeScolaireBasicDTO creer(AnneeScolaireBasicDTO basicDTO) {
        AnneeScolaire entity = mapper.toEntity(basicDTO);
        AnneeScolaire sauvegarde = repository.save(entity);
        return mapper.toBasicDTO(sauvegarde);
    }

    @Override
    public AnneeScolaireFullDTO creerComplet(AnneeScolaireFullDTO fullDTO) {
        AnneeScolaire entity = mapper.toEntity(fullDTO);
        AnneeScolaire sauvegarde = repository.save(entity);
        return mapper.toFullDTO(sauvegarde);
    }

    @Override
    @Transactional(readOnly = true)
    public AnneeScolaireFullDTO obtenirParId(Long id) {
        AnneeScolaire entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("AnneeScolaire", id));
        return mapper.toFullDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public AnneeScolaireBasicDTO obtenirBasicParId(Long id) {
        AnneeScolaire entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("AnneeScolaire", id));
        return mapper.toBasicDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AnneeScolaireFullDTO> obtenirTous() {
        return mapper.toFullDTOList(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<AnneeScolaireBasicDTO> obtenirTousBasic() {
        return mapper.toBasicDTOList(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Page<AnneeScolaireFullDTO> obtenirTous(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toFullDTO);
    }

    @Override
    public AnneeScolaireFullDTO modifier(Long id, AnneeScolaireFullDTO fullDTO) {
        AnneeScolaire entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("AnneeScolaire", id));
        mapper.updateEntityFromFullDTO(fullDTO, entity);
        AnneeScolaire sauvegarde = repository.save(entity);
        return mapper.toFullDTO(sauvegarde);
    }

    @Override
    public AnneeScolaireBasicDTO modifierBasic(Long id, AnneeScolaireBasicDTO basicDTO) {
        AnneeScolaire entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("AnneeScolaire", id));
        mapper.updateEntityFromBasicDTO(basicDTO, entity);
        AnneeScolaire sauvegarde = repository.save(entity);
        return mapper.toBasicDTO(sauvegarde);
    }

    @Override
    public void supprimer(Long id) {
        if (!repository.existsById(id)) {
            throw new RessourceIntrouvableException("AnneeScolaire", id);
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
