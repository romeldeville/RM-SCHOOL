package rmschoolapi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import rmschoolapi.dto.basic.CourNiveauBasicDTO;
import rmschoolapi.dto.full.CourNiveauFullDTO;

import java.util.List;

public interface CourNiveauService {

    CourNiveauBasicDTO creer(CourNiveauBasicDTO basicDTO);

    CourNiveauFullDTO creerComplet(CourNiveauFullDTO fullDTO);

    CourNiveauFullDTO obtenirParId(Long id);

    CourNiveauBasicDTO obtenirBasicParId(Long id);

    List<CourNiveauFullDTO> obtenirTous();

    List<CourNiveauBasicDTO> obtenirTousBasic();

    Page<CourNiveauFullDTO> obtenirTous(Pageable pageable);

    CourNiveauFullDTO modifier(Long id, CourNiveauFullDTO fullDTO);

    CourNiveauBasicDTO modifierBasic(Long id, CourNiveauBasicDTO basicDTO);

    void supprimer(Long id);

    boolean existe(Long id);

    long compter();
}
