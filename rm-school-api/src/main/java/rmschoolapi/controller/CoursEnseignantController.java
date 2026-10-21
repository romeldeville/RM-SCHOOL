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
import rmschoolapi.dto.basic.CoursEnseignantBasicDTO;
import rmschoolapi.dto.full.CoursEnseignantFullDTO;
import rmschoolapi.service.CoursEnseignantService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cours-enseignant")
@Tag(name = "CoursEnseignant", description = "Gestion des coursEnseignant")
public class CoursEnseignantController {

    private final CoursEnseignantService service;

    @PostMapping
    @Operation(summary = "CrÃ©er un coursEnseignant (BasicDTO)")
    public ResponseEntity<CoursEnseignantBasicDTO> creer(@RequestBody CoursEnseignantBasicDTO basicDTO) {
        return new ResponseEntity<>(service.creer(basicDTO), HttpStatus.CREATED);
    }

    @PostMapping("/complet")
    @Operation(summary = "CrÃ©er un coursEnseignant (FullDTO)")
    public ResponseEntity<CoursEnseignantFullDTO> creerComplet(@RequestBody CoursEnseignantFullDTO fullDTO) {
        return new ResponseEntity<>(service.creerComplet(fullDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtenir un coursEnseignant par identifiant (FullDTO)")
    public ResponseEntity<CoursEnseignantFullDTO> obtenirParId(@PathVariable @Parameter(description = "Identifiant") Long id) {
        return ResponseEntity.ok(service.obtenirParId(id));
    }

    @GetMapping("/{id}/basic")
    @Operation(summary = "Obtenir un coursEnseignant par identifiant (BasicDTO)")
    public ResponseEntity<CoursEnseignantBasicDTO> obtenirBasicParId(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenirBasicParId(id));
    }

    @GetMapping
    @Operation(summary = "Lister tous les coursEnseignant (FullDTO)")
    public ResponseEntity<List<CoursEnseignantFullDTO>> obtenirTous() {
        return ResponseEntity.ok(service.obtenirTous());
    }

    @GetMapping("/basic")
    @Operation(summary = "Lister tous les coursEnseignant (BasicDTO)")
    public ResponseEntity<List<CoursEnseignantBasicDTO>> obtenirTousBasic() {
        return ResponseEntity.ok(service.obtenirTousBasic());
    }

    @GetMapping("/page")
    @Operation(summary = "Lister tous les coursEnseignant (paginÃ©)")
    public ResponseEntity<Page<CoursEnseignantFullDTO>> obtenirTous(Pageable pageable) {
        return ResponseEntity.ok(service.obtenirTous(pageable));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier un coursEnseignant (FullDTO)")
    public ResponseEntity<CoursEnseignantFullDTO> modifier(@PathVariable Long id, @RequestBody CoursEnseignantFullDTO fullDTO) {
        return ResponseEntity.ok(service.modifier(id, fullDTO));
    }

    @PutMapping("/{id}/basic")
    @Operation(summary = "Modifier un coursEnseignant (BasicDTO)")
    public ResponseEntity<CoursEnseignantBasicDTO> modifierBasic(@PathVariable Long id, @RequestBody CoursEnseignantBasicDTO basicDTO) {
        return ResponseEntity.ok(service.modifierBasic(id, basicDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un coursEnseignant")
    public ResponseEntity<Void> supprimer(@PathVariable Long id) {
        service.supprimer(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/existe")
    @Operation(summary = "VÃ©rifier l'existence d'un coursEnseignant")
    public ResponseEntity<Boolean> existe(@PathVariable Long id) {
        return ResponseEntity.ok(service.existe(id));
    }

    @GetMapping("/compter")
    @Operation(summary = "Compter les coursEnseignant")
    public ResponseEntity<Long> compter() {
        return ResponseEntity.ok(service.compter());
    }
}
