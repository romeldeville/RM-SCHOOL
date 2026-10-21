package rmschoolapi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import rmschoolapi.dto.basic.CreneauHoraireBasicDTO;
import rmschoolapi.dto.full.CreneauHoraireFullDTO;

import java.util.List;

public interface CreneauHoraireService {

    CreneauHoraireBasicDTO creer(CreneauHoraireBasicDTO basicDTO);

    CreneauHoraireFullDTO creerComplet(CreneauHoraireFullDTO fullDTO);

    CreneauHoraireFullDTO obtenirParId(Long id);

    CreneauHoraireBasicDTO obtenirBasicParId(Long id);

    List<CreneauHoraireFullDTO> obtenirTous();

    List<CreneauHoraireBasicDTO> obtenirTousBasic();

    Page<CreneauHoraireFullDTO> obtenirTous(Pageable pageable);

    CreneauHoraireFullDTO modifier(Long id, CreneauHoraireFullDTO fullDTO);

    CreneauHoraireBasicDTO modifierBasic(Long id, CreneauHoraireBasicDTO basicDTO);

    void supprimer(Long id);

    boolean existe(Long id);

    long compter();
}
