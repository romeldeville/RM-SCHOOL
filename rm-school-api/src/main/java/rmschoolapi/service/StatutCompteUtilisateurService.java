package rmschoolapi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import rmschoolapi.dto.basic.StatutCompteUtilisateurBasicDTO;
import rmschoolapi.dto.full.StatutCompteUtilisateurFullDTO;

import java.util.List;

public interface StatutCompteUtilisateurService {

    StatutCompteUtilisateurBasicDTO creer(StatutCompteUtilisateurBasicDTO basicDTO);

    StatutCompteUtilisateurFullDTO creerComplet(StatutCompteUtilisateurFullDTO fullDTO);

    StatutCompteUtilisateurFullDTO obtenirParId(Long id);

    StatutCompteUtilisateurBasicDTO obtenirBasicParId(Long id);

    List<StatutCompteUtilisateurFullDTO> obtenirTous();

    List<StatutCompteUtilisateurBasicDTO> obtenirTousBasic();

    Page<StatutCompteUtilisateurFullDTO> obtenirTous(Pageable pageable);

    StatutCompteUtilisateurFullDTO modifier(Long id, StatutCompteUtilisateurFullDTO fullDTO);

    StatutCompteUtilisateurBasicDTO modifierBasic(Long id, StatutCompteUtilisateurBasicDTO basicDTO);

    void supprimer(Long id);

    boolean existe(Long id);

    long compter();
}
