package rmschoolapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rmschoolapi.dto.basic.SectionBasicDTO;
import rmschoolapi.dto.full.SectionFullDTO;
import rmschoolapi.entity.Section;
import rmschoolapi.exception.RessourceIntrouvableException;
import rmschoolapi.mapper.SectionMapper;
import rmschoolapi.repository.SectionRepository;
import rmschoolapi.service.SectionService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class SectionServiceImpl implements SectionService {

    private final SectionRepository repository;
    private final SectionMapper mapper;

    @Override
    public SectionBasicDTO creer(SectionBasicDTO basicDTO) {
        Section entity = mapper.toEntity(basicDTO);
        Section sauvegarde = repository.save(entity);
        return mapper.toBasicDTO(sauvegarde);
    }

    @Override
    public SectionFullDTO creerComplet(SectionFullDTO fullDTO) {
        Section entity = mapper.toEntity(fullDTO);
        Section sauvegarde = repository.save(entity);
        return mapper.toFullDTO(sauvegarde);
    }

    @Override
    @Transactional(readOnly = true)
    public SectionFullDTO obtenirParId(Long id) {
        Section entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Section", id));
        return mapper.toFullDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public SectionBasicDTO obtenirBasicParId(Long id) {
        Section entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Section", id));
        return mapper.toBasicDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SectionFullDTO> obtenirTous() {
        return mapper.toFullDTOList(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<SectionBasicDTO> obtenirTousBasic() {
        return mapper.toBasicDTOList(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Page<SectionFullDTO> obtenirTous(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toFullDTO);
    }

    @Override
    public SectionFullDTO modifier(Long id, SectionFullDTO fullDTO) {
        Section entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Section", id));
        mapper.updateEntityFromFullDTO(fullDTO, entity);
        Section sauvegarde = repository.save(entity);
        return mapper.toFullDTO(sauvegarde);
    }

    @Override
    public SectionBasicDTO modifierBasic(Long id, SectionBasicDTO basicDTO) {
        Section entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Section", id));
        mapper.updateEntityFromBasicDTO(basicDTO, entity);
        Section sauvegarde = repository.save(entity);
        return mapper.toBasicDTO(sauvegarde);
    }

    @Override
    public void supprimer(Long id) {
        if (!repository.existsById(id)) {
            throw new RessourceIntrouvableException("Section", id);
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
