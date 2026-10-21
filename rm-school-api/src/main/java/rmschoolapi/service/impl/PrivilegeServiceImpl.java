package rmschoolapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rmschoolapi.dto.basic.PrivilegeBasicDTO;
import rmschoolapi.dto.full.PrivilegeFullDTO;
import rmschoolapi.entity.Privilege;
import rmschoolapi.exception.RessourceIntrouvableException;
import rmschoolapi.mapper.PrivilegeMapper;
import rmschoolapi.repository.PrivilegeRepository;
import rmschoolapi.service.PrivilegeService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PrivilegeServiceImpl implements PrivilegeService {

    private final PrivilegeRepository repository;
    private final PrivilegeMapper mapper;

    @Override
    public PrivilegeBasicDTO creer(PrivilegeBasicDTO basicDTO) {
        Privilege entity = mapper.toEntity(basicDTO);
        Privilege sauvegarde = repository.save(entity);
        return mapper.toBasicDTO(sauvegarde);
    }

    @Override
    public PrivilegeFullDTO creerComplet(PrivilegeFullDTO fullDTO) {
        Privilege entity = mapper.toEntity(fullDTO);
        Privilege sauvegarde = repository.save(entity);
        return mapper.toFullDTO(sauvegarde);
    }

    @Override
    @Transactional(readOnly = true)
    public PrivilegeFullDTO obtenirParId(Long id) {
        Privilege entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Privilege", id));
        return mapper.toFullDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public PrivilegeBasicDTO obtenirBasicParId(Long id) {
        Privilege entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Privilege", id));
        return mapper.toBasicDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PrivilegeFullDTO> obtenirTous() {
        return mapper.toFullDTOList(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<PrivilegeBasicDTO> obtenirTousBasic() {
        return mapper.toBasicDTOList(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Page<PrivilegeFullDTO> obtenirTous(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toFullDTO);
    }

    @Override
    public PrivilegeFullDTO modifier(Long id, PrivilegeFullDTO fullDTO) {
        Privilege entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Privilege", id));
        mapper.updateEntityFromFullDTO(fullDTO, entity);
        Privilege sauvegarde = repository.save(entity);
        return mapper.toFullDTO(sauvegarde);
    }

    @Override
    public PrivilegeBasicDTO modifierBasic(Long id, PrivilegeBasicDTO basicDTO) {
        Privilege entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Privilege", id));
        mapper.updateEntityFromBasicDTO(basicDTO, entity);
        Privilege sauvegarde = repository.save(entity);
        return mapper.toBasicDTO(sauvegarde);
    }

    @Override
    public void supprimer(Long id) {
        if (!repository.existsById(id)) {
            throw new RessourceIntrouvableException("Privilege", id);
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
