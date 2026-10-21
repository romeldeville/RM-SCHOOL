package rmschoolapi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import rmschoolapi.dto.basic.CycleBasicDTO;
import rmschoolapi.dto.full.CycleFullDTO;

import java.util.List;

public interface CycleService {

    CycleBasicDTO creer(CycleBasicDTO basicDTO);

    CycleFullDTO creerComplet(CycleFullDTO fullDTO);

    CycleFullDTO obtenirParId(Long id);

    CycleBasicDTO obtenirBasicParId(Long id);

    List<CycleFullDTO> obtenirTous();

    List<CycleBasicDTO> obtenirTousBasic();

    Page<CycleFullDTO> obtenirTous(Pageable pageable);

    CycleFullDTO modifier(Long id, CycleFullDTO fullDTO);

    CycleBasicDTO modifierBasic(Long id, CycleBasicDTO basicDTO);

    void supprimer(Long id);

    boolean existe(Long id);

    long compter();
}
