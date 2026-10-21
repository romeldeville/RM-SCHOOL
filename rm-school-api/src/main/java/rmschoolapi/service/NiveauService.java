package rmschoolapi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import rmschoolapi.dto.basic.NiveauBasicDTO;
import rmschoolapi.dto.full.NiveauFullDTO;

import java.util.List;

public interface NiveauService {

    NiveauBasicDTO creer(NiveauBasicDTO basicDTO);

    NiveauFullDTO creerComplet(NiveauFullDTO fullDTO);

    NiveauFullDTO obtenirParId(Long id);

    NiveauBasicDTO obtenirBasicParId(Long id);

    List<NiveauFullDTO> obtenirTous();

    List<NiveauBasicDTO> obtenirTousBasic();

    Page<NiveauFullDTO> obtenirTous(Pageable pageable);

    NiveauFullDTO modifier(Long id, NiveauFullDTO fullDTO);

    NiveauBasicDTO modifierBasic(Long id, NiveauBasicDTO basicDTO);

    void supprimer(Long id);

    boolean existe(Long id);

    long compter();
}
