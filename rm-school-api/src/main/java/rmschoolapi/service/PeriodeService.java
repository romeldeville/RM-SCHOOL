package rmschoolapi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import rmschoolapi.dto.basic.PeriodeBasicDTO;
import rmschoolapi.dto.full.PeriodeFullDTO;

import java.util.List;

public interface PeriodeService {

    PeriodeBasicDTO creer(PeriodeBasicDTO basicDTO);

    PeriodeFullDTO creerComplet(PeriodeFullDTO fullDTO);

    PeriodeFullDTO obtenirParId(Long id);

    PeriodeBasicDTO obtenirBasicParId(Long id);

    List<PeriodeFullDTO> obtenirTous();

    List<PeriodeBasicDTO> obtenirTousBasic();

    Page<PeriodeFullDTO> obtenirTous(Pageable pageable);

    PeriodeFullDTO modifier(Long id, PeriodeFullDTO fullDTO);

    PeriodeBasicDTO modifierBasic(Long id, PeriodeBasicDTO basicDTO);

    void supprimer(Long id);

    boolean existe(Long id);

    long compter();
}
