package rmschoolapi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import rmschoolapi.dto.basic.EtablissementScolaireBasicDTO;
import rmschoolapi.dto.full.EtablissementScolaireFullDTO;

import java.util.List;

public interface EtablissementScolaireService {

    EtablissementScolaireBasicDTO creer(EtablissementScolaireBasicDTO basicDTO);

    EtablissementScolaireFullDTO creerComplet(EtablissementScolaireFullDTO fullDTO);

    EtablissementScolaireFullDTO obtenirParId(Long id);

    EtablissementScolaireBasicDTO obtenirBasicParId(Long id);

    List<EtablissementScolaireFullDTO> obtenirTous();

    List<EtablissementScolaireBasicDTO> obtenirTousBasic();

    Page<EtablissementScolaireFullDTO> obtenirTous(Pageable pageable);

    EtablissementScolaireFullDTO modifier(Long id, EtablissementScolaireFullDTO fullDTO);

    EtablissementScolaireBasicDTO modifierBasic(Long id, EtablissementScolaireBasicDTO basicDTO);

    void supprimer(Long id);

    boolean existe(Long id);

    long compter();
}
