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
import rmschoolapi.dto.basic.CycleBasicDTO;
import rmschoolapi.dto.full.CycleFullDTO;
import rmschoolapi.service.CycleService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cycle")
@Tag(name = "Cycle", description = "Gestion des cycle")
public class CycleController {

    private final CycleService service;

    @PostMapping
    @Operation(summary = "CrÃ©er un cycle (BasicDTO)")
    public ResponseEntity<CycleBasicDTO> creer(@RequestBody CycleBasicDTO basicDTO) {
        return new ResponseEntity<>(service.creer(basicDTO), HttpStatus.CREATED);
    }

    @PostMapping("/complet")
    @Operation(summary = "CrÃ©er un cycle (FullDTO)")
    public ResponseEntity<CycleFullDTO> creerComplet(@RequestBody CycleFullDTO fullDTO) {
        return new ResponseEntity<>(service.creerComplet(fullDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtenir un cycle par identifiant (FullDTO)")
    public ResponseEntity<CycleFullDTO> obtenirParId(@PathVariable @Parameter(description = "Identifiant") Long id) {
        return ResponseEntity.ok(service.obtenirParId(id));
    }

    @GetMapping("/{id}/basic")
    @Operation(summary = "Obtenir un cycle par identifiant (BasicDTO)")
    public ResponseEntity<CycleBasicDTO> obtenirBasicParId(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenirBasicParId(id));
    }

    @GetMapping
    @Operation(summary = "Lister tous les cycle (FullDTO)")
    public ResponseEntity<List<CycleFullDTO>> obtenirTous() {
        return ResponseEntity.ok(service.obtenirTous());
    }

    @GetMapping("/basic")
    @Operation(summary = "Lister tous les cycle (BasicDTO)")
    public ResponseEntity<List<CycleBasicDTO>> obtenirTousBasic() {
        return ResponseEntity.ok(service.obtenirTousBasic());
    }

    @GetMapping("/page")
    @Operation(summary = "Lister tous les cycle (paginÃ©)")
    public ResponseEntity<Page<CycleFullDTO>> obtenirTous(Pageable pageable) {
        return ResponseEntity.ok(service.obtenirTous(pageable));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier un cycle (FullDTO)")
    public ResponseEntity<CycleFullDTO> modifier(@PathVariable Long id, @RequestBody CycleFullDTO fullDTO) {
        return ResponseEntity.ok(service.modifier(id, fullDTO));
    }

    @PutMapping("/{id}/basic")
    @Operation(summary = "Modifier un cycle (BasicDTO)")
    public ResponseEntity<CycleBasicDTO> modifierBasic(@PathVariable Long id, @RequestBody CycleBasicDTO basicDTO) {
        return ResponseEntity.ok(service.modifierBasic(id, basicDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un cycle")
    public ResponseEntity<Void> supprimer(@PathVariable Long id) {
        service.supprimer(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/existe")
    @Operation(summary = "VÃ©rifier l'existence d'un cycle")
    public ResponseEntity<Boolean> existe(@PathVariable Long id) {
        return ResponseEntity.ok(service.existe(id));
    }

    @GetMapping("/compter")
    @Operation(summary = "Compter les cycle")
    public ResponseEntity<Long> compter() {
        return ResponseEntity.ok(service.compter());
    }
}
