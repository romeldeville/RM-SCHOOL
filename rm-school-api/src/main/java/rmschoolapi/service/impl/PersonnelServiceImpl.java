package rmschoolapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rmschoolapi.dto.basic.PersonnelBasicDTO;
import rmschoolapi.dto.full.PersonnelFullDTO;
import rmschoolapi.entity.Personnel;
import rmschoolapi.exception.RessourceIntrouvableException;
import rmschoolapi.mapper.PersonnelMapper;
import rmschoolapi.repository.PersonnelRepository;
import rmschoolapi.service.PersonnelService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PersonnelServiceImpl implements PersonnelService {

    private final PersonnelRepository repository;
    private final PersonnelMapper mapper;

    @Override
    public PersonnelBasicDTO creer(PersonnelBasicDTO basicDTO) {
        Personnel entity = mapper.toEntity(basicDTO);
        Personnel sauvegarde = repository.save(entity);
        return mapper.toBasicDTO(sauvegarde);
    }

    @Override
    public PersonnelFullDTO creerComplet(PersonnelFullDTO fullDTO) {
        Personnel entity = mapper.toEntity(fullDTO);
        Personnel sauvegarde = repository.save(entity);
        return mapper.toFullDTO(sauvegarde);
    }

    @Override
    @Transactional(readOnly = true)
    public PersonnelFullDTO obtenirParId(Long id) {
        Personnel entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Personnel", id));
        return mapper.toFullDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public PersonnelBasicDTO obtenirBasicParId(Long id) {
        Personnel entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Personnel", id));
        return mapper.toBasicDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PersonnelFullDTO> obtenirTous() {
        return mapper.toFullDTOList(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<PersonnelBasicDTO> obtenirTousBasic() {
        return mapper.toBasicDTOList(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Page<PersonnelFullDTO> obtenirTous(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toFullDTO);
    }

    @Override
    public PersonnelFullDTO modifier(Long id, PersonnelFullDTO fullDTO) {
        Personnel entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Personnel", id));
        mapper.updateEntityFromFullDTO(fullDTO, entity);
        Personnel sauvegarde = repository.save(entity);
        return mapper.toFullDTO(sauvegarde);
    }

    @Override
    public PersonnelBasicDTO modifierBasic(Long id, PersonnelBasicDTO basicDTO) {
        Personnel entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Personnel", id));
        mapper.updateEntityFromBasicDTO(basicDTO, entity);
        Personnel sauvegarde = repository.save(entity);
        return mapper.toBasicDTO(sauvegarde);
    }

    @Override
    public void supprimer(Long id) {
        if (!repository.existsById(id)) {
            throw new RessourceIntrouvableException("Personnel", id);
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
