package rmschoolapi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import rmschoolapi.dto.basic.ParametreBasicDTO;
import rmschoolapi.dto.full.ParametreFullDTO;

import java.util.List;

public interface ParametreService {

    ParametreBasicDTO creer(ParametreBasicDTO basicDTO);

    ParametreFullDTO creerComplet(ParametreFullDTO fullDTO);

    ParametreFullDTO obtenirParId(Long id);

    ParametreBasicDTO obtenirBasicParId(Long id);

    List<ParametreFullDTO> obtenirTous();

    List<ParametreBasicDTO> obtenirTousBasic();

    Page<ParametreFullDTO> obtenirTous(Pageable pageable);

    ParametreFullDTO modifier(Long id, ParametreFullDTO fullDTO);

    ParametreBasicDTO modifierBasic(Long id, ParametreBasicDTO basicDTO);

    void supprimer(Long id);

    boolean existe(Long id);

    long compter();
}
