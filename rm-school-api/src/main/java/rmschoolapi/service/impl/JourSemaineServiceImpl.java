package rmschoolapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rmschoolapi.dto.basic.JourSemaineBasicDTO;
import rmschoolapi.dto.full.JourSemaineFullDTO;
import rmschoolapi.entity.JourSemaine;
import rmschoolapi.exception.RessourceIntrouvableException;
import rmschoolapi.mapper.JourSemaineMapper;
import rmschoolapi.repository.JourSemaineRepository;
import rmschoolapi.service.JourSemaineService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class JourSemaineServiceImpl implements JourSemaineService {

    private final JourSemaineRepository repository;
    private final JourSemaineMapper mapper;

    @Override
    public JourSemaineBasicDTO creer(JourSemaineBasicDTO basicDTO) {
        JourSemaine entity = mapper.toEntity(basicDTO);
        JourSemaine sauvegarde = repository.save(entity);
        return mapper.toBasicDTO(sauvegarde);
    }

    @Override
    public JourSemaineFullDTO creerComplet(JourSemaineFullDTO fullDTO) {
        JourSemaine entity = mapper.toEntity(fullDTO);
        JourSemaine sauvegarde = repository.save(entity);
        return mapper.toFullDTO(sauvegarde);
    }

    @Override
    @Transactional(readOnly = true)
    public JourSemaineFullDTO obtenirParId(Long id) {
        JourSemaine entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("JourSemaine", id));
        return mapper.toFullDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public JourSemaineBasicDTO obtenirBasicParId(Long id) {
        JourSemaine entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("JourSemaine", id));
        return mapper.toBasicDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<JourSemaineFullDTO> obtenirTous() {
        return mapper.toFullDTOList(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<JourSemaineBasicDTO> obtenirTousBasic() {
        return mapper.toBasicDTOList(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Page<JourSemaineFullDTO> obtenirTous(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toFullDTO);
    }

    @Override
    public JourSemaineFullDTO modifier(Long id, JourSemaineFullDTO fullDTO) {
        JourSemaine entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("JourSemaine", id));
        mapper.updateEntityFromFullDTO(fullDTO, entity);
        JourSemaine sauvegarde = repository.save(entity);
        return mapper.toFullDTO(sauvegarde);
    }

    @Override
    public JourSemaineBasicDTO modifierBasic(Long id, JourSemaineBasicDTO basicDTO) {
        JourSemaine entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("JourSemaine", id));
        mapper.updateEntityFromBasicDTO(basicDTO, entity);
        JourSemaine sauvegarde = repository.save(entity);
        return mapper.toBasicDTO(sauvegarde);
    }

    @Override
    public void supprimer(Long id) {
        if (!repository.existsById(id)) {
            throw new RessourceIntrouvableException("JourSemaine", id);
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
