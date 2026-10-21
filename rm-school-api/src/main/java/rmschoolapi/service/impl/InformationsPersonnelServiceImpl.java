package rmschoolapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rmschoolapi.dto.basic.InformationsPersonnelBasicDTO;
import rmschoolapi.dto.full.InformationsPersonnelFullDTO;
import rmschoolapi.entity.InformationsPersonnel;
import rmschoolapi.exception.RessourceIntrouvableException;
import rmschoolapi.mapper.InformationsPersonnelMapper;
import rmschoolapi.repository.InformationsPersonnelRepository;
import rmschoolapi.service.InformationsPersonnelService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class InformationsPersonnelServiceImpl implements InformationsPersonnelService {

    private final InformationsPersonnelRepository repository;
    private final InformationsPersonnelMapper mapper;

    @Override
    public InformationsPersonnelBasicDTO creer(InformationsPersonnelBasicDTO basicDTO) {
        InformationsPersonnel entity = mapper.toEntity(basicDTO);
        InformationsPersonnel sauvegarde = repository.save(entity);
        return mapper.toBasicDTO(sauvegarde);
    }

    @Override
    public InformationsPersonnelFullDTO creerComplet(InformationsPersonnelFullDTO fullDTO) {
        InformationsPersonnel entity = mapper.toEntity(fullDTO);
        InformationsPersonnel sauvegarde = repository.save(entity);
        return mapper.toFullDTO(sauvegarde);
    }

    @Override
    @Transactional(readOnly = true)
    public InformationsPersonnelFullDTO obtenirParId(Long id) {
        InformationsPersonnel entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("InformationsPersonnel", id));
        return mapper.toFullDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public InformationsPersonnelBasicDTO obtenirBasicParId(Long id) {
        InformationsPersonnel entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("InformationsPersonnel", id));
        return mapper.toBasicDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<InformationsPersonnelFullDTO> obtenirTous() {
        return mapper.toFullDTOList(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<InformationsPersonnelBasicDTO> obtenirTousBasic() {
        return mapper.toBasicDTOList(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Page<InformationsPersonnelFullDTO> obtenirTous(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toFullDTO);
    }

    @Override
    public InformationsPersonnelFullDTO modifier(Long id, InformationsPersonnelFullDTO fullDTO) {
        InformationsPersonnel entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("InformationsPersonnel", id));
        mapper.updateEntityFromFullDTO(fullDTO, entity);
        InformationsPersonnel sauvegarde = repository.save(entity);
        return mapper.toFullDTO(sauvegarde);
    }

    @Override
    public InformationsPersonnelBasicDTO modifierBasic(Long id, InformationsPersonnelBasicDTO basicDTO) {
        InformationsPersonnel entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("InformationsPersonnel", id));
        mapper.updateEntityFromBasicDTO(basicDTO, entity);
        InformationsPersonnel sauvegarde = repository.save(entity);
        return mapper.toBasicDTO(sauvegarde);
    }

    @Override
    public void supprimer(Long id) {
        if (!repository.existsById(id)) {
            throw new RessourceIntrouvableException("InformationsPersonnel", id);
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
