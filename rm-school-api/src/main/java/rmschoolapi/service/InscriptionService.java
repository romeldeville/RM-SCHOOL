package rmschoolapi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import rmschoolapi.dto.basic.InscriptionBasicDTO;
import rmschoolapi.dto.full.InscriptionFullDTO;

import java.util.List;

public interface InscriptionService {

    InscriptionBasicDTO creer(InscriptionBasicDTO basicDTO);

    InscriptionFullDTO creerComplet(InscriptionFullDTO fullDTO);

    InscriptionFullDTO obtenirParId(Long id);

    InscriptionBasicDTO obtenirBasicParId(Long id);

    List<InscriptionFullDTO> obtenirTous();

    List<InscriptionBasicDTO> obtenirTousBasic();

    Page<InscriptionFullDTO> obtenirTous(Pageable pageable);

    InscriptionFullDTO modifier(Long id, InscriptionFullDTO fullDTO);

    InscriptionBasicDTO modifierBasic(Long id, InscriptionBasicDTO basicDTO);

    void supprimer(Long id);

    boolean existe(Long id);

    long compter();
}
