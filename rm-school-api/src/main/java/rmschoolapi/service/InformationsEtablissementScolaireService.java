package rmschoolapi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import rmschoolapi.dto.basic.InformationsEtablissementScolaireBasicDTO;
import rmschoolapi.dto.full.InformationsEtablissementScolaireFullDTO;

import java.util.List;

public interface InformationsEtablissementScolaireService {

    InformationsEtablissementScolaireBasicDTO creer(InformationsEtablissementScolaireBasicDTO basicDTO);

    InformationsEtablissementScolaireFullDTO creerComplet(InformationsEtablissementScolaireFullDTO fullDTO);

    InformationsEtablissementScolaireFullDTO obtenirParId(Long id);

    InformationsEtablissementScolaireBasicDTO obtenirBasicParId(Long id);

    List<InformationsEtablissementScolaireFullDTO> obtenirTous();

    List<InformationsEtablissementScolaireBasicDTO> obtenirTousBasic();

    Page<InformationsEtablissementScolaireFullDTO> obtenirTous(Pageable pageable);

    InformationsEtablissementScolaireFullDTO modifier(Long id, InformationsEtablissementScolaireFullDTO fullDTO);

    InformationsEtablissementScolaireBasicDTO modifierBasic(Long id, InformationsEtablissementScolaireBasicDTO basicDTO);

    void supprimer(Long id);

    boolean existe(Long id);

    long compter();
}
