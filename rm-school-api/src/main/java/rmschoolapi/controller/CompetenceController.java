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
import rmschoolapi.dto.basic.CompetenceBasicDTO;
import rmschoolapi.dto.full.CompetenceFullDTO;
import rmschoolapi.service.CompetenceService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/competence")
@Tag(name = "Competence", description = "Gestion des competence")
public class CompetenceController {

    private final CompetenceService service;

    @PostMapping
    @Operation(summary = "CrÃ©er un competence (BasicDTO)")
    public ResponseEntity<CompetenceBasicDTO> creer(@RequestBody CompetenceBasicDTO basicDTO) {
        return new ResponseEntity<>(service.creer(basicDTO), HttpStatus.CREATED);
    }

    @PostMapping("/complet")
    @Operation(summary = "CrÃ©er un competence (FullDTO)")
    public ResponseEntity<CompetenceFullDTO> creerComplet(@RequestBody CompetenceFullDTO fullDTO) {
        return new ResponseEntity<>(service.creerComplet(fullDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtenir un competence par identifiant (FullDTO)")
    public ResponseEntity<CompetenceFullDTO> obtenirParId(@PathVariable @Parameter(description = "Identifiant") Long id) {
        return ResponseEntity.ok(service.obtenirParId(id));
    }

    @GetMapping("/{id}/basic")
    @Operation(summary = "Obtenir un competence par identifiant (BasicDTO)")
    public ResponseEntity<CompetenceBasicDTO> obtenirBasicParId(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenirBasicParId(id));
    }

    @GetMapping
    @Operation(summary = "Lister tous les competence (FullDTO)")
    public ResponseEntity<List<CompetenceFullDTO>> obtenirTous() {
        return ResponseEntity.ok(service.obtenirTous());
    }

    @GetMapping("/basic")
    @Operation(summary = "Lister tous les competence (BasicDTO)")
    public ResponseEntity<List<CompetenceBasicDTO>> obtenirTousBasic() {
        return ResponseEntity.ok(service.obtenirTousBasic());
    }

    @GetMapping("/page")
    @Operation(summary = "Lister tous les competence (paginÃ©)")
    public ResponseEntity<Page<CompetenceFullDTO>> obtenirTous(Pageable pageable) {
        return ResponseEntity.ok(service.obtenirTous(pageable));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier un competence (FullDTO)")
    public ResponseEntity<CompetenceFullDTO> modifier(@PathVariable Long id, @RequestBody CompetenceFullDTO fullDTO) {
        return ResponseEntity.ok(service.modifier(id, fullDTO));
    }

    @PutMapping("/{id}/basic")
    @Operation(summary = "Modifier un competence (BasicDTO)")
    public ResponseEntity<CompetenceBasicDTO> modifierBasic(@PathVariable Long id, @RequestBody CompetenceBasicDTO basicDTO) {
        return ResponseEntity.ok(service.modifierBasic(id, basicDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un competence")
    public ResponseEntity<Void> supprimer(@PathVariable Long id) {
        service.supprimer(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/existe")
    @Operation(summary = "VÃ©rifier l'existence d'un competence")
    public ResponseEntity<Boolean> existe(@PathVariable Long id) {
        return ResponseEntity.ok(service.existe(id));
    }

    @GetMapping("/compter")
    @Operation(summary = "Compter les competence")
    public ResponseEntity<Long> compter() {
        return ResponseEntity.ok(service.compter());
    }
}
