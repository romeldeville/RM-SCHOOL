package rmschoolapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rmschoolapi.dto.basic.PeriodeBasicDTO;
import rmschoolapi.dto.full.PeriodeFullDTO;
import rmschoolapi.entity.Periode;
import rmschoolapi.exception.RessourceIntrouvableException;
import rmschoolapi.mapper.PeriodeMapper;
import rmschoolapi.repository.PeriodeRepository;
import rmschoolapi.service.PeriodeService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PeriodeServiceImpl implements PeriodeService {

    private final PeriodeRepository repository;
    private final PeriodeMapper mapper;

    @Override
    public PeriodeBasicDTO creer(PeriodeBasicDTO basicDTO) {
        Periode entity = mapper.toEntity(basicDTO);
        Periode sauvegarde = repository.save(entity);
        return mapper.toBasicDTO(sauvegarde);
    }

    @Override
    public PeriodeFullDTO creerComplet(PeriodeFullDTO fullDTO) {
        Periode entity = mapper.toEntity(fullDTO);
        Periode sauvegarde = repository.save(entity);
        return mapper.toFullDTO(sauvegarde);
    }

    @Override
    @Transactional(readOnly = true)
    public PeriodeFullDTO obtenirParId(Long id) {
        Periode entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Periode", id));
        return mapper.toFullDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public PeriodeBasicDTO obtenirBasicParId(Long id) {
        Periode entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Periode", id));
        return mapper.toBasicDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PeriodeFullDTO> obtenirTous() {
        return mapper.toFullDTOList(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<PeriodeBasicDTO> obtenirTousBasic() {
        return mapper.toBasicDTOList(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Page<PeriodeFullDTO> obtenirTous(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toFullDTO);
    }

    @Override
    public PeriodeFullDTO modifier(Long id, PeriodeFullDTO fullDTO) {
        Periode entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Periode", id));
        mapper.updateEntityFromFullDTO(fullDTO, entity);
        Periode sauvegarde = repository.save(entity);
        return mapper.toFullDTO(sauvegarde);
    }

    @Override
    public PeriodeBasicDTO modifierBasic(Long id, PeriodeBasicDTO basicDTO) {
        Periode entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("Periode", id));
        mapper.updateEntityFromBasicDTO(basicDTO, entity);
        Periode sauvegarde = repository.save(entity);
        return mapper.toBasicDTO(sauvegarde);
    }

    @Override
    public void supprimer(Long id) {
        if (!repository.existsById(id)) {
            throw new RessourceIntrouvableException("Periode", id);
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
