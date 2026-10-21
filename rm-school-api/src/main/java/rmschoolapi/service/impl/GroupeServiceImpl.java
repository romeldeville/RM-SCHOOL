package rmschoolapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rmschoolapi.dto.basic.GroupeBasicDTO;
import rmschoolapi.dto.full.GroupeFullDTO;
import rmschoolapi.entity.Groupe;
import rmschoolapi.exception.RessourceIntrouvableException;
import rmschoolapi.mapper.GroupeMapper;
import rmschoolapi.repository.GroupeRepository;
import rmschoolapi.service.GroupeService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class GroupeServiceImpl implements GroupeService {

    private final GroupeRepository repository;
    private final GroupeMapper mapper;

    @Override
    public GroupeBasicDTO creer(GroupeBasicDTO basicDTO) {
        Groupe entity = mapper.toEntity(basicDTO);
        Groupe sauvegarde = repository.save(entity);
        return mapper.toBasicDTO(sauvegarde);
    }

    @Override
    public GroupeFullDTO creerComplet(GroupeFullDTO fullDTO) {
        Groupe entity = mapper.toEntity(fullDTO);
        Groupe sauvegarde = repository.save(entity);
        return mapper.toFullDTO(sauvegarde);
    }

    @Override
    @Transactional(readOnly = true)
    public GroupeFullDTO obtenirParId(Long id) {
        Groupe entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Groupe", id));
        return mapper.toFullDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public GroupeBasicDTO obtenirBasicParId(Long id) {
        Groupe entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Groupe", id));
        return mapper.toBasicDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<GroupeFullDTO> obtenirTous() {
        return mapper.toFullDTOList(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<GroupeBasicDTO> obtenirTousBasic() {
        return mapper.toBasicDTOList(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Page<GroupeFullDTO> obtenirTous(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toFullDTO);
    }

    @Override
    public GroupeFullDTO modifier(Long id, GroupeFullDTO fullDTO) {
        Groupe entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Groupe", id));
        mapper.updateEntityFromFullDTO(fullDTO, entity);
        Groupe sauvegarde = repository.save(entity);
        return mapper.toFullDTO(sauvegarde);
    }

    @Override
    public GroupeBasicDTO modifierBasic(Long id, GroupeBasicDTO basicDTO) {
        Groupe entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Groupe", id));
        mapper.updateEntityFromBasicDTO(basicDTO, entity);
        Groupe sauvegarde = repository.save(entity);
        return mapper.toBasicDTO(sauvegarde);
    }

    @Override
    public void supprimer(Long id) {
        if (!repository.existsById(id)) {
            throw new RessourceIntrouvableException("Groupe", id);
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
