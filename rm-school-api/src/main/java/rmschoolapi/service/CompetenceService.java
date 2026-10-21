package rmschoolapi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import rmschoolapi.dto.basic.CompetenceBasicDTO;
import rmschoolapi.dto.full.CompetenceFullDTO;

import java.util.List;

public interface CompetenceService {

    CompetenceBasicDTO creer(CompetenceBasicDTO basicDTO);

    CompetenceFullDTO creerComplet(CompetenceFullDTO fullDTO);

    CompetenceFullDTO obtenirParId(Long id);

    CompetenceBasicDTO obtenirBasicParId(Long id);

    List<CompetenceFullDTO> obtenirTous();

    List<CompetenceBasicDTO> obtenirTousBasic();

    Page<CompetenceFullDTO> obtenirTous(Pageable pageable);

    CompetenceFullDTO modifier(Long id, CompetenceFullDTO fullDTO);

    CompetenceBasicDTO modifierBasic(Long id, CompetenceBasicDTO basicDTO);

    void supprimer(Long id);

    boolean existe(Long id);

    long compter();
}
