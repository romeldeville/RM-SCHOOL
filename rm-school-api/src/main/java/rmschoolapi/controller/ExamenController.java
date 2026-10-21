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
import rmschoolapi.dto.basic.ExamenBasicDTO;
import rmschoolapi.dto.full.ExamenFullDTO;
import rmschoolapi.service.ExamenService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/examen")
@Tag(name = "Examen", description = "Gestion des examen")
public class ExamenController {

    private final ExamenService service;

    @PostMapping
    @Operation(summary = "CrÃ©er un examen (BasicDTO)")
    public ResponseEntity<ExamenBasicDTO> creer(@RequestBody ExamenBasicDTO basicDTO) {
        return new ResponseEntity<>(service.creer(basicDTO), HttpStatus.CREATED);
    }

    @PostMapping("/complet")
    @Operation(summary = "CrÃ©er un examen (FullDTO)")
    public ResponseEntity<ExamenFullDTO> creerComplet(@RequestBody ExamenFullDTO fullDTO) {
        return new ResponseEntity<>(service.creerComplet(fullDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtenir un examen par identifiant (FullDTO)")
    public ResponseEntity<ExamenFullDTO> obtenirParId(@PathVariable @Parameter(description = "Identifiant") Long id) {
        return ResponseEntity.ok(service.obtenirParId(id));
    }

    @GetMapping("/{id}/basic")
    @Operation(summary = "Obtenir un examen par identifiant (BasicDTO)")
    public ResponseEntity<ExamenBasicDTO> obtenirBasicParId(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenirBasicParId(id));
    }

    @GetMapping
    @Operation(summary = "Lister tous les examen (FullDTO)")
    public ResponseEntity<List<ExamenFullDTO>> obtenirTous() {
        return ResponseEntity.ok(service.obtenirTous());
    }

    @GetMapping("/basic")
    @Operation(summary = "Lister tous les examen (BasicDTO)")
    public ResponseEntity<List<ExamenBasicDTO>> obtenirTousBasic() {
        return ResponseEntity.ok(service.obtenirTousBasic());
    }

    @GetMapping("/page")
    @Operation(summary = "Lister tous les examen (paginÃ©)")
    public ResponseEntity<Page<ExamenFullDTO>> obtenirTous(Pageable pageable) {
        return ResponseEntity.ok(service.obtenirTous(pageable));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier un examen (FullDTO)")
    public ResponseEntity<ExamenFullDTO> modifier(@PathVariable Long id, @RequestBody ExamenFullDTO fullDTO) {
        return ResponseEntity.ok(service.modifier(id, fullDTO));
    }

    @PutMapping("/{id}/basic")
    @Operation(summary = "Modifier un examen (BasicDTO)")
    public ResponseEntity<ExamenBasicDTO> modifierBasic(@PathVariable Long id, @RequestBody ExamenBasicDTO basicDTO) {
        return ResponseEntity.ok(service.modifierBasic(id, basicDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un examen")
    public ResponseEntity<Void> supprimer(@PathVariable Long id) {
        service.supprimer(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/existe")
    @Operation(summary = "VÃ©rifier l'existence d'un examen")
    public ResponseEntity<Boolean> existe(@PathVariable Long id) {
        return ResponseEntity.ok(service.existe(id));
    }

    @GetMapping("/compter")
    @Operation(summary = "Compter les examen")
    public ResponseEntity<Long> compter() {
        return ResponseEntity.ok(service.compter());
    }
}
