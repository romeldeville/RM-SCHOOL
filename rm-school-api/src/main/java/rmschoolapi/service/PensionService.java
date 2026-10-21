package rmschoolapi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import rmschoolapi.dto.basic.PensionBasicDTO;
import rmschoolapi.dto.full.PensionFullDTO;

import java.util.List;

public interface PensionService {

    PensionBasicDTO creer(PensionBasicDTO basicDTO);

    PensionFullDTO creerComplet(PensionFullDTO fullDTO);

    PensionFullDTO obtenirParId(Long id);

    PensionBasicDTO obtenirBasicParId(Long id);

    List<PensionFullDTO> obtenirTous();

    List<PensionBasicDTO> obtenirTousBasic();

    Page<PensionFullDTO> obtenirTous(Pageable pageable);

    PensionFullDTO modifier(Long id, PensionFullDTO fullDTO);

    PensionBasicDTO modifierBasic(Long id, PensionBasicDTO basicDTO);

    void supprimer(Long id);

    boolean existe(Long id);

    long compter();
}
