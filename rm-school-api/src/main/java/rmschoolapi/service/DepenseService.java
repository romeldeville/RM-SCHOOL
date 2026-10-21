package rmschoolapi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import rmschoolapi.dto.basic.DepenseBasicDTO;
import rmschoolapi.dto.full.DepenseFullDTO;

import java.util.List;

public interface DepenseService {

    DepenseBasicDTO creer(DepenseBasicDTO basicDTO);

    DepenseFullDTO creerComplet(DepenseFullDTO fullDTO);

    DepenseFullDTO obtenirParId(Long id);

    DepenseBasicDTO obtenirBasicParId(Long id);

    List<DepenseFullDTO> obtenirTous();

    List<DepenseBasicDTO> obtenirTousBasic();

    Page<DepenseFullDTO> obtenirTous(Pageable pageable);

    DepenseFullDTO modifier(Long id, DepenseFullDTO fullDTO);

    DepenseBasicDTO modifierBasic(Long id, DepenseBasicDTO basicDTO);

    void supprimer(Long id);

    boolean existe(Long id);

    long compter();
}
