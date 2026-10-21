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
import rmschoolapi.dto.basic.FraisBasicDTO;
import rmschoolapi.dto.full.FraisFullDTO;
import rmschoolapi.service.FraisService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/frais")
@Tag(name = "Frais", description = "Gestion des frais")
public class FraisController {

    private final FraisService service;

    @PostMapping
    @Operation(summary = "CrÃ©er un frais (BasicDTO)")
    public ResponseEntity<FraisBasicDTO> creer(@RequestBody FraisBasicDTO basicDTO) {
        return new ResponseEntity<>(service.creer(basicDTO), HttpStatus.CREATED);
    }

    @PostMapping("/complet")
    @Operation(summary = "CrÃ©er un frais (FullDTO)")
    public ResponseEntity<FraisFullDTO> creerComplet(@RequestBody FraisFullDTO fullDTO) {
        return new ResponseEntity<>(service.creerComplet(fullDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtenir un frais par identifiant (FullDTO)")
    public ResponseEntity<FraisFullDTO> obtenirParId(@PathVariable @Parameter(description = "Identifiant") Long id) {
        return ResponseEntity.ok(service.obtenirParId(id));
    }

    @GetMapping("/{id}/basic")
    @Operation(summary = "Obtenir un frais par identifiant (BasicDTO)")
    public ResponseEntity<FraisBasicDTO> obtenirBasicParId(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenirBasicParId(id));
    }

    @GetMapping
    @Operation(summary = "Lister tous les frais (FullDTO)")
    public ResponseEntity<List<FraisFullDTO>> obtenirTous() {
        return ResponseEntity.ok(service.obtenirTous());
    }

    @GetMapping("/basic")
    @Operation(summary = "Lister tous les frais (BasicDTO)")
    public ResponseEntity<List<FraisBasicDTO>> obtenirTousBasic() {
        return ResponseEntity.ok(service.obtenirTousBasic());
    }

    @GetMapping("/page")
    @Operation(summary = "Lister tous les frais (paginÃ©)")
    public ResponseEntity<Page<FraisFullDTO>> obtenirTous(Pageable pageable) {
        return ResponseEntity.ok(service.obtenirTous(pageable));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier un frais (FullDTO)")
    public ResponseEntity<FraisFullDTO> modifier(@PathVariable Long id, @RequestBody FraisFullDTO fullDTO) {
        return ResponseEntity.ok(service.modifier(id, fullDTO));
    }

    @PutMapping("/{id}/basic")
    @Operation(summary = "Modifier un frais (BasicDTO)")
    public ResponseEntity<FraisBasicDTO> modifierBasic(@PathVariable Long id, @RequestBody FraisBasicDTO basicDTO) {
        return ResponseEntity.ok(service.modifierBasic(id, basicDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un frais")
    public ResponseEntity<Void> supprimer(@PathVariable Long id) {
        service.supprimer(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/existe")
    @Operation(summary = "VÃ©rifier l'existence d'un frais")
    public ResponseEntity<Boolean> existe(@PathVariable Long id) {
        return ResponseEntity.ok(service.existe(id));
    }

    @GetMapping("/compter")
    @Operation(summary = "Compter les frais")
    public ResponseEntity<Long> compter() {
        return ResponseEntity.ok(service.compter());
    }
}
