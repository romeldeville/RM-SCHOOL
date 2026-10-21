package rmschoolapi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import rmschoolapi.dto.basic.RoleBasicDTO;
import rmschoolapi.dto.full.RoleFullDTO;

import java.util.List;

public interface RoleService {

    RoleBasicDTO creer(RoleBasicDTO basicDTO);

    RoleFullDTO creerComplet(RoleFullDTO fullDTO);

    RoleFullDTO obtenirParId(Long id);

    RoleBasicDTO obtenirBasicParId(Long id);

    List<RoleFullDTO> obtenirTous();

    List<RoleBasicDTO> obtenirTousBasic();

    Page<RoleFullDTO> obtenirTous(Pageable pageable);

    RoleFullDTO modifier(Long id, RoleFullDTO fullDTO);

    RoleBasicDTO modifierBasic(Long id, RoleBasicDTO basicDTO);

    void supprimer(Long id);

    boolean existe(Long id);

    long compter();
}
