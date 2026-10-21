package rmschoolapi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import rmschoolapi.dto.basic.EleveBasicDTO;
import rmschoolapi.dto.full.EleveFullDTO;

import java.util.List;

public interface EleveService {

    EleveBasicDTO creer(EleveBasicDTO basicDTO);

    EleveFullDTO creerComplet(EleveFullDTO fullDTO);

    EleveFullDTO obtenirParId(Long id);

    EleveBasicDTO obtenirBasicParId(Long id);

    List<EleveFullDTO> obtenirTous();

    List<EleveBasicDTO> obtenirTousBasic();

    Page<EleveFullDTO> obtenirTous(Pageable pageable);

    EleveFullDTO modifier(Long id, EleveFullDTO fullDTO);

    EleveBasicDTO modifierBasic(Long id, EleveBasicDTO basicDTO);

    void supprimer(Long id);

    boolean existe(Long id);

    long compter();
}
