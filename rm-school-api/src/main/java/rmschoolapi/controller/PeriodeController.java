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
import rmschoolapi.dto.basic.PeriodeBasicDTO;
import rmschoolapi.dto.full.PeriodeFullDTO;
import rmschoolapi.service.PeriodeService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/periode")
@Tag(name = "Periode", description = "Gestion des periode")
public class PeriodeController {

    private final PeriodeService service;

    @PostMapping
    @Operation(summary = "CrÃ©er un periode (BasicDTO)")
    public ResponseEntity<PeriodeBasicDTO> creer(@RequestBody PeriodeBasicDTO basicDTO) {
        return new ResponseEntity<>(service.creer(basicDTO), HttpStatus.CREATED);
    }

    @PostMapping("/complet")
    @Operation(summary = "CrÃ©er un periode (FullDTO)")
    public ResponseEntity<PeriodeFullDTO> creerComplet(@RequestBody PeriodeFullDTO fullDTO) {
        return new ResponseEntity<>(service.creerComplet(fullDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtenir un periode par identifiant (FullDTO)")
    public ResponseEntity<PeriodeFullDTO> obtenirParId(@PathVariable @Parameter(description = "Identifiant") Long id) {
        return ResponseEntity.ok(service.obtenirParId(id));
    }

    @GetMapping("/{id}/basic")
    @Operation(summary = "Obtenir un periode par identifiant (BasicDTO)")
    public ResponseEntity<PeriodeBasicDTO> obtenirBasicParId(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenirBasicParId(id));
    }

    @GetMapping
    @Operation(summary = "Lister tous les periode (FullDTO)")
    public ResponseEntity<List<PeriodeFullDTO>> obtenirTous() {
        return ResponseEntity.ok(service.obtenirTous());
    }

    @GetMapping("/basic")
    @Operation(summary = "Lister tous les periode (BasicDTO)")
    public ResponseEntity<List<PeriodeBasicDTO>> obtenirTousBasic() {
        return ResponseEntity.ok(service.obtenirTousBasic());
    }

    @GetMapping("/page")
    @Operation(summary = "Lister tous les periode (paginÃ©)")
    public ResponseEntity<Page<PeriodeFullDTO>> obtenirTous(Pageable pageable) {
        return ResponseEntity.ok(service.obtenirTous(pageable));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier un periode (FullDTO)")
    public ResponseEntity<PeriodeFullDTO> modifier(@PathVariable Long id, @RequestBody PeriodeFullDTO fullDTO) {
        return ResponseEntity.ok(service.modifier(id, fullDTO));
    }

    @PutMapping("/{id}/basic")
    @Operation(summary = "Modifier un periode (BasicDTO)")
    public ResponseEntity<PeriodeBasicDTO> modifierBasic(@PathVariable Long id, @RequestBody PeriodeBasicDTO basicDTO) {
        return ResponseEntity.ok(service.modifierBasic(id, basicDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un periode")
    public ResponseEntity<Void> supprimer(@PathVariable Long id) {
        service.supprimer(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/existe")
    @Operation(summary = "VÃ©rifier l'existence d'un periode")
    public ResponseEntity<Boolean> existe(@PathVariable Long id) {
        return ResponseEntity.ok(service.existe(id));
    }

    @GetMapping("/compter")
    @Operation(summary = "Compter les periode")
    public ResponseEntity<Long> compter() {
        return ResponseEntity.ok(service.compter());
    }
}
