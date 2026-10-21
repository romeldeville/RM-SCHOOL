package rmschoolapi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import rmschoolapi.dto.basic.ClasseBasicDTO;
import rmschoolapi.dto.full.ClasseFullDTO;

import java.util.List;

public interface ClasseService {

    ClasseBasicDTO creer(ClasseBasicDTO basicDTO);

    ClasseFullDTO creerComplet(ClasseFullDTO fullDTO);

    ClasseFullDTO obtenirParId(Long id);

    ClasseBasicDTO obtenirBasicParId(Long id);

    List<ClasseFullDTO> obtenirTous();

    List<ClasseBasicDTO> obtenirTousBasic();

    Page<ClasseFullDTO> obtenirTous(Pageable pageable);

    ClasseFullDTO modifier(Long id, ClasseFullDTO fullDTO);

    ClasseBasicDTO modifierBasic(Long id, ClasseBasicDTO basicDTO);

    void supprimer(Long id);

    boolean existe(Long id);

    long compter();
}
