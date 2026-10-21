package rmschoolapi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import rmschoolapi.dto.basic.NoteBasicDTO;
import rmschoolapi.dto.full.NoteFullDTO;

import java.util.List;

public interface NoteService {

    NoteBasicDTO creer(NoteBasicDTO basicDTO);

    NoteFullDTO creerComplet(NoteFullDTO fullDTO);

    NoteFullDTO obtenirParId(Long id);

    NoteBasicDTO obtenirBasicParId(Long id);

    List<NoteFullDTO> obtenirTous();

    List<NoteBasicDTO> obtenirTousBasic();

    Page<NoteFullDTO> obtenirTous(Pageable pageable);

    NoteFullDTO modifier(Long id, NoteFullDTO fullDTO);

    NoteBasicDTO modifierBasic(Long id, NoteBasicDTO basicDTO);

    void supprimer(Long id);

    boolean existe(Long id);

    long compter();
}
