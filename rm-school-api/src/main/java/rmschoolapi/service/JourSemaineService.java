package rmschoolapi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import rmschoolapi.dto.basic.JourSemaineBasicDTO;
import rmschoolapi.dto.full.JourSemaineFullDTO;

import java.util.List;

public interface JourSemaineService {

    JourSemaineBasicDTO creer(JourSemaineBasicDTO basicDTO);

    JourSemaineFullDTO creerComplet(JourSemaineFullDTO fullDTO);

    JourSemaineFullDTO obtenirParId(Long id);

    JourSemaineBasicDTO obtenirBasicParId(Long id);

    List<JourSemaineFullDTO> obtenirTous();

    List<JourSemaineBasicDTO> obtenirTousBasic();

    Page<JourSemaineFullDTO> obtenirTous(Pageable pageable);

    JourSemaineFullDTO modifier(Long id, JourSemaineFullDTO fullDTO);

    JourSemaineBasicDTO modifierBasic(Long id, JourSemaineBasicDTO basicDTO);

    void supprimer(Long id);

    boolean existe(Long id);

    long compter();
}
