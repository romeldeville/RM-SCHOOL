package rmschoolapi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import rmschoolapi.dto.basic.PersonnelBasicDTO;
import rmschoolapi.dto.full.PersonnelFullDTO;

import java.util.List;

public interface PersonnelService {

    PersonnelBasicDTO creer(PersonnelBasicDTO basicDTO);

    PersonnelFullDTO creerComplet(PersonnelFullDTO fullDTO);

    PersonnelFullDTO obtenirParId(Long id);

    PersonnelBasicDTO obtenirBasicParId(Long id);

    List<PersonnelFullDTO> obtenirTous();

    List<PersonnelBasicDTO> obtenirTousBasic();

    Page<PersonnelFullDTO> obtenirTous(Pageable pageable);

    PersonnelFullDTO modifier(Long id, PersonnelFullDTO fullDTO);

    PersonnelBasicDTO modifierBasic(Long id, PersonnelBasicDTO basicDTO);

    void supprimer(Long id);

    boolean existe(Long id);

    long compter();
}
