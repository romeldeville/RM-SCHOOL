package rmschoolapi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import rmschoolapi.dto.basic.FraisBasicDTO;
import rmschoolapi.dto.full.FraisFullDTO;

import java.util.List;

public interface FraisService {

    FraisBasicDTO creer(FraisBasicDTO basicDTO);

    FraisFullDTO creerComplet(FraisFullDTO fullDTO);

    FraisFullDTO obtenirParId(Long id);

    FraisBasicDTO obtenirBasicParId(Long id);

    List<FraisFullDTO> obtenirTous();

    List<FraisBasicDTO> obtenirTousBasic();

    Page<FraisFullDTO> obtenirTous(Pageable pageable);

    FraisFullDTO modifier(Long id, FraisFullDTO fullDTO);

    FraisBasicDTO modifierBasic(Long id, FraisBasicDTO basicDTO);

    void supprimer(Long id);

    boolean existe(Long id);

    long compter();
}
