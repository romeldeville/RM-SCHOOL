package rmschoolapi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import rmschoolapi.dto.basic.ExamenBasicDTO;
import rmschoolapi.dto.full.ExamenFullDTO;

import java.util.List;

public interface ExamenService {

    ExamenBasicDTO creer(ExamenBasicDTO basicDTO);

    ExamenFullDTO creerComplet(ExamenFullDTO fullDTO);

    ExamenFullDTO obtenirParId(Long id);

    ExamenBasicDTO obtenirBasicParId(Long id);

    List<ExamenFullDTO> obtenirTous();

    List<ExamenBasicDTO> obtenirTousBasic();

    Page<ExamenFullDTO> obtenirTous(Pageable pageable);

    ExamenFullDTO modifier(Long id, ExamenFullDTO fullDTO);

    ExamenBasicDTO modifierBasic(Long id, ExamenBasicDTO basicDTO);

    void supprimer(Long id);

    boolean existe(Long id);

    long compter();
}
