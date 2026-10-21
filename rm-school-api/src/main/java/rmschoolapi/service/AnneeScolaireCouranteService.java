package rmschoolapi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import rmschoolapi.dto.basic.AnneeScolaireCouranteBasicDTO;
import rmschoolapi.dto.full.AnneeScolaireCouranteFullDTO;

import java.util.List;

public interface AnneeScolaireCouranteService {

    AnneeScolaireCouranteBasicDTO creer(AnneeScolaireCouranteBasicDTO basicDTO);

    AnneeScolaireCouranteFullDTO creerComplet(AnneeScolaireCouranteFullDTO fullDTO);

    AnneeScolaireCouranteFullDTO obtenirParId(Long id);

    AnneeScolaireCouranteBasicDTO obtenirBasicParId(Long id);

    List<AnneeScolaireCouranteFullDTO> obtenirTous();

    List<AnneeScolaireCouranteBasicDTO> obtenirTousBasic();

    Page<AnneeScolaireCouranteFullDTO> obtenirTous(Pageable pageable);

    AnneeScolaireCouranteFullDTO modifier(Long id, AnneeScolaireCouranteFullDTO fullDTO);

    AnneeScolaireCouranteBasicDTO modifierBasic(Long id, AnneeScolaireCouranteBasicDTO basicDTO);

    void supprimer(Long id);

    boolean existe(Long id);

    long compter();
}
