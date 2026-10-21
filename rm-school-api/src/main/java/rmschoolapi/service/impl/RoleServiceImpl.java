package rmschoolapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rmschoolapi.dto.basic.RoleBasicDTO;
import rmschoolapi.dto.full.RoleFullDTO;
import rmschoolapi.entity.Role;
import rmschoolapi.exception.RessourceIntrouvableException;
import rmschoolapi.mapper.RoleMapper;
import rmschoolapi.repository.RoleRepository;
import rmschoolapi.service.RoleService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class RoleServiceImpl implements RoleService {

    private final RoleRepository repository;
    private final RoleMapper mapper;

    @Override
    public RoleBasicDTO creer(RoleBasicDTO basicDTO) {
        Role entity = mapper.toEntity(basicDTO);
        Role sauvegarde = repository.save(entity);
        return mapper.toBasicDTO(sauvegarde);
    }

    @Override
    public RoleFullDTO creerComplet(RoleFullDTO fullDTO) {
        Role entity = mapper.toEntity(fullDTO);
        Role sauvegarde = repository.save(entity);
        return mapper.toFullDTO(sauvegarde);
    }

    @Override
    @Transactional(readOnly = true)
    public RoleFullDTO obtenirParId(Long id) {
        Role entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Role", id));
        return mapper.toFullDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public RoleBasicDTO obtenirBasicParId(Long id) {
        Role entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Role", id));
        return mapper.toBasicDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<RoleFullDTO> obtenirTous() {
        return mapper.toFullDTOList(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<RoleBasicDTO> obtenirTousBasic() {
        return mapper.toBasicDTOList(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Page<RoleFullDTO> obtenirTous(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toFullDTO);
    }

    @Override
    public RoleFullDTO modifier(Long id, RoleFullDTO fullDTO) {
        Role entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Role", id));
        mapper.updateEntityFromFullDTO(fullDTO, entity);
        Role sauvegarde = repository.save(entity);
        return mapper.toFullDTO(sauvegarde);
    }

    @Override
    public RoleBasicDTO modifierBasic(Long id, RoleBasicDTO basicDTO) {
        Role entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Role", id));
        mapper.updateEntityFromBasicDTO(basicDTO, entity);
        Role sauvegarde = repository.save(entity);
        return mapper.toBasicDTO(sauvegarde);
    }

    @Override
    public void supprimer(Long id) {
        if (!repository.existsById(id)) {
            throw new RessourceIntrouvableException("Role", id);
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
