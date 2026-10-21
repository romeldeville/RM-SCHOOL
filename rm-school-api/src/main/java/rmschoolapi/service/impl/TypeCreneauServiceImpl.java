package rmschoolapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rmschoolapi.dto.basic.TypeCreneauBasicDTO;
import rmschoolapi.dto.full.TypeCreneauFullDTO;
import rmschoolapi.entity.TypeCreneau;
import rmschoolapi.exception.RessourceIntrouvableException;
import rmschoolapi.mapper.TypeCreneauMapper;
import rmschoolapi.repository.TypeCreneauRepository;
import rmschoolapi.service.TypeCreneauService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TypeCreneauServiceImpl implements TypeCreneauService {

    private final TypeCreneauRepository repository;
    private final TypeCreneauMapper mapper;

    @Override
    public TypeCreneauBasicDTO creer(TypeCreneauBasicDTO basicDTO) {
        TypeCreneau entity = mapper.toEntity(basicDTO);
        TypeCreneau sauvegarde = repository.save(entity);
        return mapper.toBasicDTO(sauvegarde);
    }

    @Override
    public TypeCreneauFullDTO creerComplet(TypeCreneauFullDTO fullDTO) {
        TypeCreneau entity = mapper.toEntity(fullDTO);
        TypeCreneau sauvegarde = repository.save(entity);
        return mapper.toFullDTO(sauvegarde);
    }

    @Override
    @Transactional(readOnly = true)
    public TypeCreneauFullDTO obtenirParId(Long id) {
        TypeCreneau entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("TypeCreneau", id));
        return mapper.toFullDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public TypeCreneauBasicDTO obtenirBasicParId(Long id) {
        TypeCreneau entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("TypeCreneau", id));
        return mapper.toBasicDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TypeCreneauFullDTO> obtenirTous() {
        return mapper.toFullDTOList(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<TypeCreneauBasicDTO> obtenirTousBasic() {
        return mapper.toBasicDTOList(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Page<TypeCreneauFullDTO> obtenirTous(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toFullDTO);
    }

    @Override
    public TypeCreneauFullDTO modifier(Long id, TypeCreneauFullDTO fullDTO) {
        TypeCreneau entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("TypeCreneau", id));
        mapper.updateEntityFromFullDTO(fullDTO, entity);
        TypeCreneau sauvegarde = repository.save(entity);
        return mapper.toFullDTO(sauvegarde);
    }

    @Override
    public TypeCreneauBasicDTO modifierBasic(Long id, TypeCreneauBasicDTO basicDTO) {
        TypeCreneau entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("TypeCreneau", id));
        mapper.updateEntityFromBasicDTO(basicDTO, entity);
        TypeCreneau sauvegarde = repository.save(entity);
        return mapper.toBasicDTO(sauvegarde);
    }

    @Override
    public void supprimer(Long id) {
        if (!repository.existsById(id)) {
            throw new RessourceIntrouvableException("TypeCreneau", id);
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
