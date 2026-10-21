package rmschoolapi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import rmschoolapi.dto.basic.LigneEmploiDuTempsBasicDTO;
import rmschoolapi.dto.full.LigneEmploiDuTempsFullDTO;

import java.util.List;

public interface LigneEmploiDuTempsService {

    LigneEmploiDuTempsBasicDTO creer(LigneEmploiDuTempsBasicDTO basicDTO);

    LigneEmploiDuTempsFullDTO creerComplet(LigneEmploiDuTempsFullDTO fullDTO);

    LigneEmploiDuTempsFullDTO obtenirParId(Long id);

    LigneEmploiDuTempsBasicDTO obtenirBasicParId(Long id);

    List<LigneEmploiDuTempsFullDTO> obtenirTous();

    List<LigneEmploiDuTempsBasicDTO> obtenirTousBasic();

    Page<LigneEmploiDuTempsFullDTO> obtenirTous(Pageable pageable);

    LigneEmploiDuTempsFullDTO modifier(Long id, LigneEmploiDuTempsFullDTO fullDTO);

    LigneEmploiDuTempsBasicDTO modifierBasic(Long id, LigneEmploiDuTempsBasicDTO basicDTO);

    void supprimer(Long id);

    boolean existe(Long id);

    long compter();
}
