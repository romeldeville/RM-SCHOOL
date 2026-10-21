package rmschoolapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rmschoolapi.dto.basic.InscriptionBasicDTO;
import rmschoolapi.dto.full.InscriptionFullDTO;
import rmschoolapi.entity.Inscription;
import rmschoolapi.exception.RessourceIntrouvableException;
import rmschoolapi.mapper.InscriptionMapper;
import rmschoolapi.repository.InscriptionRepository;
import rmschoolapi.service.InscriptionService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class InscriptionServiceImpl implements InscriptionService {

    private final InscriptionRepository repository;
    private final InscriptionMapper mapper;

    @Override
    public InscriptionBasicDTO creer(InscriptionBasicDTO basicDTO) {
        Inscription entity = mapper.toEntity(basicDTO);
        Inscription sauvegarde = repository.save(entity);
        return mapper.toBasicDTO(sauvegarde);
    }

    @Override
    public InscriptionFullDTO creerComplet(InscriptionFullDTO fullDTO) {
        Inscription entity = mapper.toEntity(fullDTO);
        Inscription sauvegarde = repository.save(entity);
        return mapper.toFullDTO(sauvegarde);
    }

    @Override
    @Transactional(readOnly = true)
    public InscriptionFullDTO obtenirParId(Long id) {
        Inscription entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Inscription", id));
        return mapper.toFullDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public InscriptionBasicDTO obtenirBasicParId(Long id) {
        Inscription entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Inscription", id));
        return mapper.toBasicDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<InscriptionFullDTO> obtenirTous() {
        return mapper.toFullDTOList(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<InscriptionBasicDTO> obtenirTousBasic() {
        return mapper.toBasicDTOList(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Page<InscriptionFullDTO> obtenirTous(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toFullDTO);
    }

    @Override
    public InscriptionFullDTO modifier(Long id, InscriptionFullDTO fullDTO) {
        Inscription entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Inscription", id));
        mapper.updateEntityFromFullDTO(fullDTO, entity);
        Inscription sauvegarde = repository.save(entity);
        return mapper.toFullDTO(sauvegarde);
    }

    @Override
    public InscriptionBasicDTO modifierBasic(Long id, InscriptionBasicDTO basicDTO) {
        Inscription entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Inscription", id));
        mapper.updateEntityFromBasicDTO(basicDTO, entity);
        Inscription sauvegarde = repository.save(entity);
        return mapper.toBasicDTO(sauvegarde);
    }

    @Override
    public void supprimer(Long id) {
        if (!repository.existsById(id)) {
            throw new RessourceIntrouvableException("Inscription", id);
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
