package rmschoolapi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import rmschoolapi.dto.basic.CompteUtilisateurBasicDTO;
import rmschoolapi.dto.full.CompteUtilisateurFullDTO;

import java.util.List;

public interface CompteUtilisateurService {

    CompteUtilisateurBasicDTO creer(CompteUtilisateurBasicDTO basicDTO);

    CompteUtilisateurFullDTO creerComplet(CompteUtilisateurFullDTO fullDTO);

    CompteUtilisateurFullDTO obtenirParId(Long id);

    CompteUtilisateurBasicDTO obtenirBasicParId(Long id);

    List<CompteUtilisateurFullDTO> obtenirTous();

    List<CompteUtilisateurBasicDTO> obtenirTousBasic();

    Page<CompteUtilisateurFullDTO> obtenirTous(Pageable pageable);

    CompteUtilisateurFullDTO modifier(Long id, CompteUtilisateurFullDTO fullDTO);

    CompteUtilisateurBasicDTO modifierBasic(Long id, CompteUtilisateurBasicDTO basicDTO);

    void supprimer(Long id);

    boolean existe(Long id);

    long compter();
}
