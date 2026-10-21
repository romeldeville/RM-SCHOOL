package rmschoolapi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import rmschoolapi.dto.basic.CoursEnseignantBasicDTO;
import rmschoolapi.dto.full.CoursEnseignantFullDTO;

import java.util.List;

public interface CoursEnseignantService {

    CoursEnseignantBasicDTO creer(CoursEnseignantBasicDTO basicDTO);

    CoursEnseignantFullDTO creerComplet(CoursEnseignantFullDTO fullDTO);

    CoursEnseignantFullDTO obtenirParId(Long id);

    CoursEnseignantBasicDTO obtenirBasicParId(Long id);

    List<CoursEnseignantFullDTO> obtenirTous();

    List<CoursEnseignantBasicDTO> obtenirTousBasic();

    Page<CoursEnseignantFullDTO> obtenirTous(Pageable pageable);

    CoursEnseignantFullDTO modifier(Long id, CoursEnseignantFullDTO fullDTO);

    CoursEnseignantBasicDTO modifierBasic(Long id, CoursEnseignantBasicDTO basicDTO);

    void supprimer(Long id);

    boolean existe(Long id);

    long compter();
}
