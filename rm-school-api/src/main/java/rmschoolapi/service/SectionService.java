package rmschoolapi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import rmschoolapi.dto.basic.SectionBasicDTO;
import rmschoolapi.dto.full.SectionFullDTO;

import java.util.List;

public interface SectionService {

    SectionBasicDTO creer(SectionBasicDTO basicDTO);

    SectionFullDTO creerComplet(SectionFullDTO fullDTO);

    SectionFullDTO obtenirParId(Long id);

    SectionBasicDTO obtenirBasicParId(Long id);

    List<SectionFullDTO> obtenirTous();

    List<SectionBasicDTO> obtenirTousBasic();

    Page<SectionFullDTO> obtenirTous(Pageable pageable);

    SectionFullDTO modifier(Long id, SectionFullDTO fullDTO);

    SectionBasicDTO modifierBasic(Long id, SectionBasicDTO basicDTO);

    void supprimer(Long id);

    boolean existe(Long id);

    long compter();
}
