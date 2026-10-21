package rmschoolapi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import rmschoolapi.dto.basic.DisciplineBasicDTO;
import rmschoolapi.dto.full.DisciplineFullDTO;

import java.util.List;

public interface DisciplineService {

    DisciplineBasicDTO creer(DisciplineBasicDTO basicDTO);

    DisciplineFullDTO creerComplet(DisciplineFullDTO fullDTO);

    DisciplineFullDTO obtenirParId(Long id);

    DisciplineBasicDTO obtenirBasicParId(Long id);

    List<DisciplineFullDTO> obtenirTous();

    List<DisciplineBasicDTO> obtenirTousBasic();

    Page<DisciplineFullDTO> obtenirTous(Pageable pageable);

    DisciplineFullDTO modifier(Long id, DisciplineFullDTO fullDTO);

    DisciplineBasicDTO modifierBasic(Long id, DisciplineBasicDTO basicDTO);

    void supprimer(Long id);

    boolean existe(Long id);

    long compter();
}
