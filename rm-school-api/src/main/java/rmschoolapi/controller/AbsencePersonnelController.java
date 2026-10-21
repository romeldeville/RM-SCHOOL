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
import rmschoolapi.dto.basic.AbsencePersonnelBasicDTO;
import rmschoolapi.dto.full.AbsencePersonnelFullDTO;
import rmschoolapi.service.AbsencePersonnelService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/absence-personnel")
@Tag(name = "AbsencePersonnel", description = "Gestion des absencePersonnel")
public class AbsencePersonnelController {

    private final AbsencePersonnelService service;

    @PostMapping
    @Operation(summary = "CrÃ©er un absencePersonnel (BasicDTO)")
    public ResponseEntity<AbsencePersonnelBasicDTO> creer(@RequestBody AbsencePersonnelBasicDTO basicDTO) {
        return new ResponseEntity<>(service.creer(basicDTO), HttpStatus.CREATED);
    }

    @PostMapping("/complet")
    @Operation(summary = "CrÃ©er un absencePersonnel (FullDTO)")
    public ResponseEntity<AbsencePersonnelFullDTO> creerComplet(@RequestBody AbsencePersonnelFullDTO fullDTO) {
        return new ResponseEntity<>(service.creerComplet(fullDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtenir un absencePersonnel par identifiant (FullDTO)")
    public ResponseEntity<AbsencePersonnelFullDTO> obtenirParId(@PathVariable @Parameter(description = "Identifiant") Long id) {
        return ResponseEntity.ok(service.obtenirParId(id));
    }

    @GetMapping("/{id}/basic")
    @Operation(summary = "Obtenir un absencePersonnel par identifiant (BasicDTO)")
    public ResponseEntity<AbsencePersonnelBasicDTO> obtenirBasicParId(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenirBasicParId(id));
    }

    @GetMapping
    @Operation(summary = "Lister tous les absencePersonnel (FullDTO)")
    public ResponseEntity<List<AbsencePersonnelFullDTO>> obtenirTous() {
        return ResponseEntity.ok(service.obtenirTous());
    }

    @GetMapping("/basic")
    @Operation(summary = "Lister tous les absencePersonnel (BasicDTO)")
    public ResponseEntity<List<AbsencePersonnelBasicDTO>> obtenirTousBasic() {
        return ResponseEntity.ok(service.obtenirTousBasic());
    }

    @GetMapping("/page")
    @Operation(summary = "Lister tous les absencePersonnel (paginÃ©)")
    public ResponseEntity<Page<AbsencePersonnelFullDTO>> obtenirTous(Pageable pageable) {
        return ResponseEntity.ok(service.obtenirTous(pageable));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier un absencePersonnel (FullDTO)")
    public ResponseEntity<AbsencePersonnelFullDTO> modifier(@PathVariable Long id, @RequestBody AbsencePersonnelFullDTO fullDTO) {
        return ResponseEntity.ok(service.modifier(id, fullDTO));
    }

    @PutMapping("/{id}/basic")
    @Operation(summary = "Modifier un absencePersonnel (BasicDTO)")
    public ResponseEntity<AbsencePersonnelBasicDTO> modifierBasic(@PathVariable Long id, @RequestBody AbsencePersonnelBasicDTO basicDTO) {
        return ResponseEntity.ok(service.modifierBasic(id, basicDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un absencePersonnel")
    public ResponseEntity<Void> supprimer(@PathVariable Long id) {
        service.supprimer(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/existe")
    @Operation(summary = "VÃ©rifier l'existence d'un absencePersonnel")
    public ResponseEntity<Boolean> existe(@PathVariable Long id) {
        return ResponseEntity.ok(service.existe(id));
    }

    @GetMapping("/compter")
    @Operation(summary = "Compter les absencePersonnel")
    public ResponseEntity<Long> compter() {
        return ResponseEntity.ok(service.compter());
    }
}
