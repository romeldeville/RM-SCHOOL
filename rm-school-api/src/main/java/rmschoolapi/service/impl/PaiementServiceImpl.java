package rmschoolapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rmschoolapi.dto.basic.PaiementBasicDTO;
import rmschoolapi.dto.full.PaiementFullDTO;
import rmschoolapi.entity.Paiement;
import rmschoolapi.exception.RessourceIntrouvableException;
import rmschoolapi.mapper.PaiementMapper;
import rmschoolapi.repository.PaiementRepository;
import rmschoolapi.service.PaiementService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PaiementServiceImpl implements PaiementService {

    private final PaiementRepository repository;
    private final PaiementMapper mapper;

    @Override
    public PaiementBasicDTO creer(PaiementBasicDTO basicDTO) {
        Paiement entity = mapper.toEntity(basicDTO);
        Paiement sauvegarde = repository.save(entity);
        return mapper.toBasicDTO(sauvegarde);
    }

    @Override
    public PaiementFullDTO creerComplet(PaiementFullDTO fullDTO) {
        Paiement entity = mapper.toEntity(fullDTO);
        Paiement sauvegarde = repository.save(entity);
        return mapper.toFullDTO(sauvegarde);
    }

    @Override
    @Transactional(readOnly = true)
    public PaiementFullDTO obtenirParId(Long id) {
        Paiement entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Paiement", id));
        return mapper.toFullDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public PaiementBasicDTO obtenirBasicParId(Long id) {
        Paiement entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Paiement", id));
        return mapper.toBasicDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PaiementFullDTO> obtenirTous() {
        return mapper.toFullDTOList(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<PaiementBasicDTO> obtenirTousBasic() {
        return mapper.toBasicDTOList(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Page<PaiementFullDTO> obtenirTous(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toFullDTO);
    }

    @Override
    public PaiementFullDTO modifier(Long id, PaiementFullDTO fullDTO) {
        Paiement entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Paiement", id));
        mapper.updateEntityFromFullDTO(fullDTO, entity);
        Paiement sauvegarde = repository.save(entity);
        return mapper.toFullDTO(sauvegarde);
    }

    @Override
    public PaiementBasicDTO modifierBasic(Long id, PaiementBasicDTO basicDTO) {
        Paiement entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Paiement", id));
        mapper.updateEntityFromBasicDTO(basicDTO, entity);
        Paiement sauvegarde = repository.save(entity);
        return mapper.toBasicDTO(sauvegarde);
    }

    @Override
    public void supprimer(Long id) {
        if (!repository.existsById(id)) {
            throw new RessourceIntrouvableException("Paiement", id);
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
