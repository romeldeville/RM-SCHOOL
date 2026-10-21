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
import rmschoolapi.dto.basic.DepenseBasicDTO;
import rmschoolapi.dto.full.DepenseFullDTO;
import rmschoolapi.service.DepenseService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/depense")
@Tag(name = "Depense", description = "Gestion des depense")
public class DepenseController {

    private final DepenseService service;

    @PostMapping
    @Operation(summary = "CrÃ©er un depense (BasicDTO)")
    public ResponseEntity<DepenseBasicDTO> creer(@RequestBody DepenseBasicDTO basicDTO) {
        return new ResponseEntity<>(service.creer(basicDTO), HttpStatus.CREATED);
    }

    @PostMapping("/complet")
    @Operation(summary = "CrÃ©er un depense (FullDTO)")
    public ResponseEntity<DepenseFullDTO> creerComplet(@RequestBody DepenseFullDTO fullDTO) {
        return new ResponseEntity<>(service.creerComplet(fullDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtenir un depense par identifiant (FullDTO)")
    public ResponseEntity<DepenseFullDTO> obtenirParId(@PathVariable @Parameter(description = "Identifiant") Long id) {
        return ResponseEntity.ok(service.obtenirParId(id));
    }

    @GetMapping("/{id}/basic")
    @Operation(summary = "Obtenir un depense par identifiant (BasicDTO)")
    public ResponseEntity<DepenseBasicDTO> obtenirBasicParId(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenirBasicParId(id));
    }

    @GetMapping
    @Operation(summary = "Lister tous les depense (FullDTO)")
    public ResponseEntity<List<DepenseFullDTO>> obtenirTous() {
        return ResponseEntity.ok(service.obtenirTous());
    }

    @GetMapping("/basic")
    @Operation(summary = "Lister tous les depense (BasicDTO)")
    public ResponseEntity<List<DepenseBasicDTO>> obtenirTousBasic() {
        return ResponseEntity.ok(service.obtenirTousBasic());
    }

    @GetMapping("/page")
    @Operation(summary = "Lister tous les depense (paginÃ©)")
    public ResponseEntity<Page<DepenseFullDTO>> obtenirTous(Pageable pageable) {
        return ResponseEntity.ok(service.obtenirTous(pageable));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier un depense (FullDTO)")
    public ResponseEntity<DepenseFullDTO> modifier(@PathVariable Long id, @RequestBody DepenseFullDTO fullDTO) {
        return ResponseEntity.ok(service.modifier(id, fullDTO));
    }

    @PutMapping("/{id}/basic")
    @Operation(summary = "Modifier un depense (BasicDTO)")
    public ResponseEntity<DepenseBasicDTO> modifierBasic(@PathVariable Long id, @RequestBody DepenseBasicDTO basicDTO) {
        return ResponseEntity.ok(service.modifierBasic(id, basicDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un depense")
    public ResponseEntity<Void> supprimer(@PathVariable Long id) {
        service.supprimer(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/existe")
    @Operation(summary = "VÃ©rifier l'existence d'un depense")
    public ResponseEntity<Boolean> existe(@PathVariable Long id) {
        return ResponseEntity.ok(service.existe(id));
    }

    @GetMapping("/compter")
    @Operation(summary = "Compter les depense")
    public ResponseEntity<Long> compter() {
        return ResponseEntity.ok(service.compter());
    }
}
