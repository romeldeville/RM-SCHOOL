package rmschoolapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rmschoolapi.dto.basic.AnneeScolaireCouranteBasicDTO;
import rmschoolapi.dto.full.AnneeScolaireCouranteFullDTO;
import rmschoolapi.entity.AnneeScolaireCourante;
import rmschoolapi.exception.RessourceIntrouvableException;
import rmschoolapi.mapper.AnneeScolaireCouranteMapper;
import rmschoolapi.repository.AnneeScolaireCouranteRepository;
import rmschoolapi.service.AnneeScolaireCouranteService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AnneeScolaireCouranteServiceImpl implements AnneeScolaireCouranteService {

    private final AnneeScolaireCouranteRepository repository;
    private final AnneeScolaireCouranteMapper mapper;

    @Override
    public AnneeScolaireCouranteBasicDTO creer(AnneeScolaireCouranteBasicDTO basicDTO) {
        AnneeScolaireCourante entity = mapper.toEntity(basicDTO);
        AnneeScolaireCourante sauvegarde = repository.save(entity);
        return mapper.toBasicDTO(sauvegarde);
    }

    @Override
    public AnneeScolaireCouranteFullDTO creerComplet(AnneeScolaireCouranteFullDTO fullDTO) {
        AnneeScolaireCourante entity = mapper.toEntity(fullDTO);
        AnneeScolaireCourante sauvegarde = repository.save(entity);
        return mapper.toFullDTO(sauvegarde);
    }

    @Override
    @Transactional(readOnly = true)
    public AnneeScolaireCouranteFullDTO obtenirParId(Long id) {
        AnneeScolaireCourante entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("AnneeScolaireCourante", id));
        return mapper.toFullDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public AnneeScolaireCouranteBasicDTO obtenirBasicParId(Long id) {
        AnneeScolaireCourante entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("AnneeScolaireCourante", id));
        return mapper.toBasicDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AnneeScolaireCouranteFullDTO> obtenirTous() {
        return mapper.toFullDTOList(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<AnneeScolaireCouranteBasicDTO> obtenirTousBasic() {
        return mapper.toBasicDTOList(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Page<AnneeScolaireCouranteFullDTO> obtenirTous(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toFullDTO);
    }

    @Override
    public AnneeScolaireCouranteFullDTO modifier(Long id, AnneeScolaireCouranteFullDTO fullDTO) {
        AnneeScolaireCourante entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("AnneeScolaireCourante", id));
        mapper.updateEntityFromFullDTO(fullDTO, entity);
        AnneeScolaireCourante sauvegarde = repository.save(entity);
        return mapper.toFullDTO(sauvegarde);
    }

    @Override
    public AnneeScolaireCouranteBasicDTO modifierBasic(Long id, AnneeScolaireCouranteBasicDTO basicDTO) {
        AnneeScolaireCourante entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("AnneeScolaireCourante", id));
        mapper.updateEntityFromBasicDTO(basicDTO, entity);
        AnneeScolaireCourante sauvegarde = repository.save(entity);
        return mapper.toBasicDTO(sauvegarde);
    }

    @Override
    public void supprimer(Long id) {
        if (!repository.existsById(id)) {
            throw new RessourceIntrouvableException("AnneeScolaireCourante", id);
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
