package rmschoolapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rmschoolapi.dto.basic.AbsenceEleveBasicDTO;
import rmschoolapi.dto.full.AbsenceEleveFullDTO;
import rmschoolapi.entity.AbsenceEleve;
import rmschoolapi.exception.RessourceIntrouvableException;
import rmschoolapi.mapper.AbsenceEleveMapper;
import rmschoolapi.repository.AbsenceEleveRepository;
import rmschoolapi.service.AbsenceEleveService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AbsenceEleveServiceImpl implements AbsenceEleveService {

    private final AbsenceEleveRepository repository;
    private final AbsenceEleveMapper mapper;

    @Override
    public AbsenceEleveBasicDTO creer(AbsenceEleveBasicDTO basicDTO) {
        AbsenceEleve entity = mapper.toEntity(basicDTO);
        AbsenceEleve sauvegarde = repository.save(entity);
        return mapper.toBasicDTO(sauvegarde);
    }

    @Override
    public AbsenceEleveFullDTO creerComplet(AbsenceEleveFullDTO fullDTO) {
        AbsenceEleve entity = mapper.toEntity(fullDTO);
        AbsenceEleve sauvegarde = repository.save(entity);
        return mapper.toFullDTO(sauvegarde);
    }

    @Override
    @Transactional(readOnly = true)
    public AbsenceEleveFullDTO obtenirParId(Long id) {
        AbsenceEleve entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("AbsenceEleve", id));
        return mapper.toFullDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public AbsenceEleveBasicDTO obtenirBasicParId(Long id) {
        AbsenceEleve entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("AbsenceEleve", id));
        return mapper.toBasicDTO(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AbsenceEleveFullDTO> obtenirTous() {
        return mapper.toFullDTOList(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<AbsenceEleveBasicDTO> obtenirTousBasic() {
        return mapper.toBasicDTOList(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Page<AbsenceEleveFullDTO> obtenirTous(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toFullDTO);
    }

    @Override
    public AbsenceEleveFullDTO modifier(Long id, AbsenceEleveFullDTO fullDTO) {
        AbsenceEleve entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("AbsenceEleve", id));
        mapper.updateEntityFromFullDTO(fullDTO, entity);
        AbsenceEleve sauvegarde = repository.save(entity);
        return mapper.toFullDTO(sauvegarde);
    }

    @Override
    public AbsenceEleveBasicDTO modifierBasic(Long id, AbsenceEleveBasicDTO basicDTO) {
        AbsenceEleve entity = repository.findById(id)
                .orElseThrow(() -> new RessourceIntrouvableException("AbsenceEleve", id));
        mapper.updateEntityFromBasicDTO(basicDTO, entity);
        AbsenceEleve sauvegarde = repository.save(entity);
        return mapper.toBasicDTO(sauvegarde);
    }

    @Override
    public void supprimer(Long id) {
        if (!repository.existsById(id)) {
            throw new RessourceIntrouvableException("AbsenceEleve", id);
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
