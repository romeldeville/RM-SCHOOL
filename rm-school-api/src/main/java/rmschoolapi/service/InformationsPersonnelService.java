package rmschoolapi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import rmschoolapi.dto.basic.InformationsPersonnelBasicDTO;
import rmschoolapi.dto.full.InformationsPersonnelFullDTO;

import java.util.List;

public interface InformationsPersonnelService {

    InformationsPersonnelBasicDTO creer(InformationsPersonnelBasicDTO basicDTO);

    InformationsPersonnelFullDTO creerComplet(InformationsPersonnelFullDTO fullDTO);

    InformationsPersonnelFullDTO obtenirParId(Long id);

    InformationsPersonnelBasicDTO obtenirBasicParId(Long id);

    List<InformationsPersonnelFullDTO> obtenirTous();

    List<InformationsPersonnelBasicDTO> obtenirTousBasic();

    Page<InformationsPersonnelFullDTO> obtenirTous(Pageable pageable);

    InformationsPersonnelFullDTO modifier(Long id, InformationsPersonnelFullDTO fullDTO);

    InformationsPersonnelBasicDTO modifierBasic(Long id, InformationsPersonnelBasicDTO basicDTO);

    void supprimer(Long id);

    boolean existe(Long id);

    long compter();
}
