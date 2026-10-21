package rmschoolapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rmschoolapi.dto.basic.AbsencePersonnelBasicDTO;
import rmschoolapi.dto.full.AbsencePersonnelFullDTO;
import rmschoolapi.entity.AbsencePersonnel;
import rmschoolapi.exception.RessourceIntrouvableException;
import rmschoolapi.mapper.AbsencePersonnelMapper;
import rmschoolapi.repository.AbsencePersonnelRepository;
import rmschoolapi.service.AbsencePersonnelService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AbsencePersonnelServiceImpl implements AbsencePersonnelService {

    private final AbsencePersonnelRepository repository;
    private final AbsencePersonnelMapper mapper;

    @Override
    public AbsencePersonnelBasicDTO creer(AbsencePersonnelBasicDTO basicDTO) {
        AbsencePersonnel entity = mapper.toEntity(basicDTO);
        AbsencePersonnel sauvegarde = repository.save(entity);
        return mapper.toBasicDTO(sauvegarde);
    }

    @Override
    public AbsencePersonnelFullDTO creerComplet(AbsencePersonnelFullDTO fullDTO) {
        AbsencePersonnel entity = mapper.toEntity(fullDTO);
        AbsencePersonnel sauvegarde = repository.save(entity);
        return mapper.toFullDTO(sauvegarde);
    }

    @Override
    @Transactional(readOnly = true)
    public AbsencePersonnelFullDTO obtenirParId(Long id) {
        AbsencePersonnel entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("AbsencePersonnel", id));
        return mapper.toFullDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public AbsencePersonnelBasicDTO obtenirBasicParId(Long id) {
        AbsencePersonnel entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("AbsencePersonnel", id));
        return mapper.toBasicDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AbsencePersonnelFullDTO> obtenirTous() {
        return mapper.toFullDTOList(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<AbsencePersonnelBasicDTO> obtenirTousBasic() {
        return mapper.toBasicDTOList(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Page<AbsencePersonnelFullDTO> obtenirTous(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toFullDTO);
    }

    @Override
    public AbsencePersonnelFullDTO modifier(Long id, AbsencePersonnelFullDTO fullDTO) {
        AbsencePersonnel entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("AbsencePersonnel", id));
        mapper.updateEntityFromFullDTO(fullDTO, entity);
        AbsencePersonnel sauvegarde = repository.save(entity);
        return mapper.toFullDTO(sauvegarde);
    }

    @Override
    public AbsencePersonnelBasicDTO modifierBasic(Long id, AbsencePersonnelBasicDTO basicDTO) {
        AbsencePersonnel entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("AbsencePersonnel", id));
        mapper.updateEntityFromBasicDTO(basicDTO, entity);
        AbsencePersonnel sauvegarde = repository.save(entity);
        return mapper.toBasicDTO(sauvegarde);
    }

    @Override
    public void supprimer(Long id) {
        if (!repository.existsById(id)) {
            throw new RessourceIntrouvableException("AbsencePersonnel", id);
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
