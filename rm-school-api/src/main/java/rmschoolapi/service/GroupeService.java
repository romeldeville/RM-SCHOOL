package rmschoolapi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import rmschoolapi.dto.basic.GroupeBasicDTO;
import rmschoolapi.dto.full.GroupeFullDTO;

import java.util.List;

public interface GroupeService {

    GroupeBasicDTO creer(GroupeBasicDTO basicDTO);

    GroupeFullDTO creerComplet(GroupeFullDTO fullDTO);

    GroupeFullDTO obtenirParId(Long id);

    GroupeBasicDTO obtenirBasicParId(Long id);

    List<GroupeFullDTO> obtenirTous();

    List<GroupeBasicDTO> obtenirTousBasic();

    Page<GroupeFullDTO> obtenirTous(Pageable pageable);

    GroupeFullDTO modifier(Long id, GroupeFullDTO fullDTO);

    GroupeBasicDTO modifierBasic(Long id, GroupeBasicDTO basicDTO);

    void supprimer(Long id);

    boolean existe(Long id);

    long compter();
}
