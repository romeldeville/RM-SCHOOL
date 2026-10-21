package rmschoolapi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import rmschoolapi.dto.basic.AbsencePersonnelBasicDTO;
import rmschoolapi.dto.full.AbsencePersonnelFullDTO;

import java.util.List;

public interface AbsencePersonnelService {

    AbsencePersonnelBasicDTO creer(AbsencePersonnelBasicDTO basicDTO);

    AbsencePersonnelFullDTO creerComplet(AbsencePersonnelFullDTO fullDTO);

    AbsencePersonnelFullDTO obtenirParId(Long id);

    AbsencePersonnelBasicDTO obtenirBasicParId(Long id);

    List<AbsencePersonnelFullDTO> obtenirTous();

    List<AbsencePersonnelBasicDTO> obtenirTousBasic();

    Page<AbsencePersonnelFullDTO> obtenirTous(Pageable pageable);

    AbsencePersonnelFullDTO modifier(Long id, AbsencePersonnelFullDTO fullDTO);

    AbsencePersonnelBasicDTO modifierBasic(Long id, AbsencePersonnelBasicDTO basicDTO);

    void supprimer(Long id);

    boolean existe(Long id);

    long compter();
}
