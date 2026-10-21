package rmschoolapi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import rmschoolapi.dto.basic.AnneeScolaireBasicDTO;
import rmschoolapi.dto.full.AnneeScolaireFullDTO;

import java.util.List;

public interface AnneeScolaireService {

    AnneeScolaireBasicDTO creer(AnneeScolaireBasicDTO basicDTO);

    AnneeScolaireFullDTO creerComplet(AnneeScolaireFullDTO fullDTO);

    AnneeScolaireFullDTO obtenirParId(Long id);

    AnneeScolaireBasicDTO obtenirBasicParId(Long id);

    List<AnneeScolaireFullDTO> obtenirTous();

    List<AnneeScolaireBasicDTO> obtenirTousBasic();

    Page<AnneeScolaireFullDTO> obtenirTous(Pageable pageable);

    AnneeScolaireFullDTO modifier(Long id, AnneeScolaireFullDTO fullDTO);

    AnneeScolaireBasicDTO modifierBasic(Long id, AnneeScolaireBasicDTO basicDTO);

    void supprimer(Long id);

    boolean existe(Long id);

    long compter();
}
