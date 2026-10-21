package rmschoolapi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import rmschoolapi.dto.basic.TypeCreneauBasicDTO;
import rmschoolapi.dto.full.TypeCreneauFullDTO;

import java.util.List;

public interface TypeCreneauService {

    TypeCreneauBasicDTO creer(TypeCreneauBasicDTO basicDTO);

    TypeCreneauFullDTO creerComplet(TypeCreneauFullDTO fullDTO);

    TypeCreneauFullDTO obtenirParId(Long id);

    TypeCreneauBasicDTO obtenirBasicParId(Long id);

    List<TypeCreneauFullDTO> obtenirTous();

    List<TypeCreneauBasicDTO> obtenirTousBasic();

    Page<TypeCreneauFullDTO> obtenirTous(Pageable pageable);

    TypeCreneauFullDTO modifier(Long id, TypeCreneauFullDTO fullDTO);

    TypeCreneauBasicDTO modifierBasic(Long id, TypeCreneauBasicDTO basicDTO);

    void supprimer(Long id);

    boolean existe(Long id);

    long compter();
}
