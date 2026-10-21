package rmschoolapi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import rmschoolapi.dto.basic.PaiementBasicDTO;
import rmschoolapi.dto.full.PaiementFullDTO;

import java.util.List;

public interface PaiementService {

    PaiementBasicDTO creer(PaiementBasicDTO basicDTO);

    PaiementFullDTO creerComplet(PaiementFullDTO fullDTO);

    PaiementFullDTO obtenirParId(Long id);

    PaiementBasicDTO obtenirBasicParId(Long id);

    List<PaiementFullDTO> obtenirTous();

    List<PaiementBasicDTO> obtenirTousBasic();

    Page<PaiementFullDTO> obtenirTous(Pageable pageable);

    PaiementFullDTO modifier(Long id, PaiementFullDTO fullDTO);

    PaiementBasicDTO modifierBasic(Long id, PaiementBasicDTO basicDTO);

    void supprimer(Long id);

    boolean existe(Long id);

    long compter();
}
