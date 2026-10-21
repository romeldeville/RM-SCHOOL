package rmschoolapi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import rmschoolapi.dto.basic.AbsenceEleveBasicDTO;
import rmschoolapi.dto.full.AbsenceEleveFullDTO;

import java.util.List;

public interface AbsenceEleveService {

    AbsenceEleveBasicDTO creer(AbsenceEleveBasicDTO basicDTO);

    AbsenceEleveFullDTO creerComplet(AbsenceEleveFullDTO fullDTO);

    AbsenceEleveFullDTO obtenirParId(Long id);

    AbsenceEleveBasicDTO obtenirBasicParId(Long id);

    List<AbsenceEleveFullDTO> obtenirTous();

    List<AbsenceEleveBasicDTO> obtenirTousBasic();

    Page<AbsenceEleveFullDTO> obtenirTous(Pageable pageable);

    AbsenceEleveFullDTO modifier(Long id, AbsenceEleveFullDTO fullDTO);

    AbsenceEleveBasicDTO modifierBasic(Long id, AbsenceEleveBasicDTO basicDTO);

    void supprimer(Long id);

    boolean existe(Long id);

    long compter();
}
