package rmschoolapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rmschoolapi.dto.basic.CreneauHoraireBasicDTO;
import rmschoolapi.dto.full.CreneauHoraireFullDTO;
import rmschoolapi.entity.CreneauHoraire;
import rmschoolapi.exception.RessourceIntrouvableException;
import rmschoolapi.mapper.CreneauHoraireMapper;
import rmschoolapi.repository.CreneauHoraireRepository;
import rmschoolapi.service.CreneauHoraireService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CreneauHoraireServiceImpl implements CreneauHoraireService {

    private final CreneauHoraireRepository repository;
    private final CreneauHoraireMapper mapper;

    @Override
    public CreneauHoraireBasicDTO creer(CreneauHoraireBasicDTO basicDTO) {
        CreneauHoraire entity = mapper.toEntity(basicDTO);
        CreneauHoraire sauvegarde = repository.save(entity);
        return mapper.toBasicDTO(sauvegarde);
    }

    @Override
    public CreneauHoraireFullDTO creerComplet(CreneauHoraireFullDTO fullDTO) {
        CreneauHoraire entity = mapper.toEntity(fullDTO);
        CreneauHoraire sauvegarde = repository.save(entity);
        return mapper.toFullDTO(sauvegarde);
    }

    @Override
    @Transactional(readOnly = true)
    public CreneauHoraireFullDTO obtenirParId(Long id) {
        CreneauHoraire entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("CreneauHoraire", id));
        return mapper.toFullDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public CreneauHoraireBasicDTO obtenirBasicParId(Long id) {
        CreneauHoraire entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("CreneauHoraire", id));
        return mapper.toBasicDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CreneauHoraireFullDTO> obtenirTous() {
        return mapper.toFullDTOList(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<CreneauHoraireBasicDTO> obtenirTousBasic() {
        return mapper.toBasicDTOList(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Page<CreneauHoraireFullDTO> obtenirTous(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toFullDTO);
    }

    @Override
    public CreneauHoraireFullDTO modifier(Long id, CreneauHoraireFullDTO fullDTO) {
        CreneauHoraire entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("CreneauHoraire", id));
        mapper.updateEntityFromFullDTO(fullDTO, entity);
        CreneauHoraire sauvegarde = repository.save(entity);
        return mapper.toFullDTO(sauvegarde);
    }

    @Override
    public CreneauHoraireBasicDTO modifierBasic(Long id, CreneauHoraireBasicDTO basicDTO) {
        CreneauHoraire entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("CreneauHoraire", id));
        mapper.updateEntityFromBasicDTO(basicDTO, entity);
        CreneauHoraire sauvegarde = repository.save(entity);
        return mapper.toBasicDTO(sauvegarde);
    }

    @Override
    public void supprimer(Long id) {
        if (!repository.existsById(id)) {
            throw new RessourceIntrouvableException("CreneauHoraire", id);
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
