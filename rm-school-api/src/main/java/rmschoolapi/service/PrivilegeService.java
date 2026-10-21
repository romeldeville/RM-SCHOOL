package rmschoolapi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import rmschoolapi.dto.basic.PrivilegeBasicDTO;
import rmschoolapi.dto.full.PrivilegeFullDTO;

import java.util.List;

public interface PrivilegeService {

    PrivilegeBasicDTO creer(PrivilegeBasicDTO basicDTO);

    PrivilegeFullDTO creerComplet(PrivilegeFullDTO fullDTO);

    PrivilegeFullDTO obtenirParId(Long id);

    PrivilegeBasicDTO obtenirBasicParId(Long id);

    List<PrivilegeFullDTO> obtenirTous();

    List<PrivilegeBasicDTO> obtenirTousBasic();

    Page<PrivilegeFullDTO> obtenirTous(Pageable pageable);

    PrivilegeFullDTO modifier(Long id, PrivilegeFullDTO fullDTO);

    PrivilegeBasicDTO modifierBasic(Long id, PrivilegeBasicDTO basicDTO);

    void supprimer(Long id);

    boolean existe(Long id);

    long compter();
}
