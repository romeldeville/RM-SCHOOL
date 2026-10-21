package rmschoolapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rmschoolapi.dto.basic.ClasseBasicDTO;
import rmschoolapi.dto.full.ClasseFullDTO;
import rmschoolapi.entity.Classe;
import rmschoolapi.exception.RessourceIntrouvableException;
import rmschoolapi.mapper.ClasseMapper;
import rmschoolapi.repository.ClasseRepository;
import rmschoolapi.service.ClasseService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ClasseServiceImpl implements ClasseService {

    private final ClasseRepository repository;
    private final ClasseMapper mapper;

    @Override
    public ClasseBasicDTO creer(ClasseBasicDTO basicDTO) {
        Classe entity = mapper.toEntity(basicDTO);
        Classe sauvegarde = repository.save(entity);
        return mapper.toBasicDTO(sauvegarde);
    }

    @Override
    public ClasseFullDTO creerComplet(ClasseFullDTO fullDTO) {
        Classe entity = mapper.toEntity(fullDTO);
        Classe sauvegarde = repository.save(entity);
        return mapper.toFullDTO(sauvegarde);
    }

    @Override
    @Transactional(readOnly = true)
    public ClasseFullDTO obtenirParId(Long id) {
        Classe entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Classe", id));
        return mapper.toFullDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public ClasseBasicDTO obtenirBasicParId(Long id) {
        Classe entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Classe", id));
        return mapper.toBasicDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ClasseFullDTO> obtenirTous() {
        return mapper.toFullDTOList(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ClasseBasicDTO> obtenirTousBasic() {
        return mapper.toBasicDTOList(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ClasseFullDTO> obtenirTous(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toFullDTO);
    }

    @Override
    public ClasseFullDTO modifier(Long id, ClasseFullDTO fullDTO) {
        Classe entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Classe", id));
        mapper.updateEntityFromFullDTO(fullDTO, entity);
        Classe sauvegarde = repository.save(entity);
        return mapper.toFullDTO(sauvegarde);
    }

    @Override
    public ClasseBasicDTO modifierBasic(Long id, ClasseBasicDTO basicDTO) {
        Classe entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Classe", id));
        mapper.updateEntityFromBasicDTO(basicDTO, entity);
        Classe sauvegarde = repository.save(entity);
        return mapper.toBasicDTO(sauvegarde);
    }

    @Override
    public void supprimer(Long id) {
        if (!repository.existsById(id)) {
            throw new RessourceIntrouvableException("Classe", id);
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
