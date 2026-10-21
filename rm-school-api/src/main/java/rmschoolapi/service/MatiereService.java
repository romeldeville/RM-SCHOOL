package rmschoolapi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import rmschoolapi.dto.basic.MatiereBasicDTO;
import rmschoolapi.dto.full.MatiereFullDTO;

import java.util.List;

public interface MatiereService {

    MatiereBasicDTO creer(MatiereBasicDTO basicDTO);

    MatiereFullDTO creerComplet(MatiereFullDTO fullDTO);

    MatiereFullDTO obtenirParId(Long id);

    MatiereBasicDTO obtenirBasicParId(Long id);

    List<MatiereFullDTO> obtenirTous();

    List<MatiereBasicDTO> obtenirTousBasic();

    Page<MatiereFullDTO> obtenirTous(Pageable pageable);

    MatiereFullDTO modifier(Long id, MatiereFullDTO fullDTO);

    MatiereBasicDTO modifierBasic(Long id, MatiereBasicDTO basicDTO);

    void supprimer(Long id);

    boolean existe(Long id);

    long compter();
}
