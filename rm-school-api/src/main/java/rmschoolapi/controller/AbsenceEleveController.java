package rmschoolapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rmschoolapi.dto.basic.AbsenceEleveBasicDTO;
import rmschoolapi.dto.full.AbsenceEleveFullDTO;
import rmschoolapi.service.AbsenceEleveService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/absence-eleve")
@Tag(name = "AbsenceEleve", description = "Gestion des absenceEleve")
public class AbsenceEleveController {

    private final AbsenceEleveService service;

    @PostMapping
    @Operation(summary = "CrÃ©er un absenceEleve (BasicDTO)")
    public ResponseEntity<AbsenceEleveBasicDTO> creer(@RequestBody AbsenceEleveBasicDTO basicDTO) {
        return new ResponseEntity<>(service.creer(basicDTO), HttpStatus.CREATED);
    }

    @PostMapping("/complet")
    @Operation(summary = "CrÃ©er un absenceEleve (FullDTO)")
    public ResponseEntity<AbsenceEleveFullDTO> creerComplet(@RequestBody AbsenceEleveFullDTO fullDTO) {
        return new ResponseEntity<>(service.creerComplet(fullDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtenir un absenceEleve par identifiant (FullDTO)")
    public ResponseEntity<AbsenceEleveFullDTO> obtenirParId(@PathVariable @Parameter(description = "Identifiant") Long id) {
        return ResponseEntity.ok(service.obtenirParId(id));
    }

    @GetMapping("/{id}/basic")
    @Operation(summary = "Obtenir un absenceEleve par identifiant (BasicDTO)")
    public ResponseEntity<AbsenceEleveBasicDTO> obtenirBasicParId(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenirBasicParId(id));
    }

    @GetMapping
    @Operation(summary = "Lister tous les absenceEleve (FullDTO)")
    public ResponseEntity<List<AbsenceEleveFullDTO>> obtenirTous() {
        return ResponseEntity.ok(service.obtenirTous());
    }

    @GetMapping("/basic")
    @Operation(summary = "Lister tous les absenceEleve (BasicDTO)")
    public ResponseEntity<List<AbsenceEleveBasicDTO>> obtenirTousBasic() {
        return ResponseEntity.ok(service.obtenirTousBasic());
    }

    @GetMapping("/page")
    @Operation(summary = "Lister tous les absenceEleve (paginÃ©)")
    public ResponseEntity<Page<AbsenceEleveFullDTO>> obtenirTous(Pageable pageable) {
        return ResponseEntity.ok(service.obtenirTous(pageable));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier un absenceEleve (FullDTO)")
    public ResponseEntity<AbsenceEleveFullDTO> modifier(@PathVariable Long id, @RequestBody AbsenceEleveFullDTO fullDTO) {
        return ResponseEntity.ok(service.modifier(id, fullDTO));
    }

    @PutMapping("/{id}/basic")
    @Operation(summary = "Modifier un absenceEleve (BasicDTO)")
    public ResponseEntity<AbsenceEleveBasicDTO> modifierBasic(@PathVariable Long id, @RequestBody AbsenceEleveBasicDTO basicDTO) {
        return ResponseEntity.ok(service.modifierBasic(id, basicDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un absenceEleve")
    public ResponseEntity<Void> supprimer(@PathVariable Long id) {
        service.supprimer(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/existe")
    @Operation(summary = "VÃ©rifier l'existence d'un absenceEleve")
    public ResponseEntity<Boolean> existe(@PathVariable Long id) {
        return ResponseEntity.ok(service.existe(id));
    }

    @GetMapping("/compter")
    @Operation(summary = "Compter les absenceEleve")
    public ResponseEntity<Long> compter() {
        return ResponseEntity.ok(service.compter());
    }
}
