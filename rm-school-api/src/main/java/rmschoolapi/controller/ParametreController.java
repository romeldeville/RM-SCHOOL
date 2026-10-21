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
import rmschoolapi.dto.basic.ParametreBasicDTO;
import rmschoolapi.dto.full.ParametreFullDTO;
import rmschoolapi.service.ParametreService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/parametre")
@Tag(name = "Parametre", description = "Gestion des parametre")
public class ParametreController {

    private final ParametreService service;

    @PostMapping
    @Operation(summary = "CrÃ©er un parametre (BasicDTO)")
    public ResponseEntity<ParametreBasicDTO> creer(@RequestBody ParametreBasicDTO basicDTO) {
        return new ResponseEntity<>(service.creer(basicDTO), HttpStatus.CREATED);
    }

    @PostMapping("/complet")
    @Operation(summary = "CrÃ©er un parametre (FullDTO)")
    public ResponseEntity<ParametreFullDTO> creerComplet(@RequestBody ParametreFullDTO fullDTO) {
        return new ResponseEntity<>(service.creerComplet(fullDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtenir un parametre par identifiant (FullDTO)")
    public ResponseEntity<ParametreFullDTO> obtenirParId(@PathVariable @Parameter(description = "Identifiant") Long id) {
        return ResponseEntity.ok(service.obtenirParId(id));
    }

    @GetMapping("/{id}/basic")
    @Operation(summary = "Obtenir un parametre par identifiant (BasicDTO)")
    public ResponseEntity<ParametreBasicDTO> obtenirBasicParId(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenirBasicParId(id));
    }

    @GetMapping
    @Operation(summary = "Lister tous les parametre (FullDTO)")
    public ResponseEntity<List<ParametreFullDTO>> obtenirTous() {
        return ResponseEntity.ok(service.obtenirTous());
    }

    @GetMapping("/basic")
    @Operation(summary = "Lister tous les parametre (BasicDTO)")
    public ResponseEntity<List<ParametreBasicDTO>> obtenirTousBasic() {
        return ResponseEntity.ok(service.obtenirTousBasic());
    }

    @GetMapping("/page")
    @Operation(summary = "Lister tous les parametre (paginÃ©)")
    public ResponseEntity<Page<ParametreFullDTO>> obtenirTous(Pageable pageable) {
        return ResponseEntity.ok(service.obtenirTous(pageable));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier un parametre (FullDTO)")
    public ResponseEntity<ParametreFullDTO> modifier(@PathVariable Long id, @RequestBody ParametreFullDTO fullDTO) {
        return ResponseEntity.ok(service.modifier(id, fullDTO));
    }

    @PutMapping("/{id}/basic")
    @Operation(summary = "Modifier un parametre (BasicDTO)")
    public ResponseEntity<ParametreBasicDTO> modifierBasic(@PathVariable Long id, @RequestBody ParametreBasicDTO basicDTO) {
        return ResponseEntity.ok(service.modifierBasic(id, basicDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un parametre")
    public ResponseEntity<Void> supprimer(@PathVariable Long id) {
        service.supprimer(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/existe")
    @Operation(summary = "VÃ©rifier l'existence d'un parametre")
    public ResponseEntity<Boolean> existe(@PathVariable Long id) {
        return ResponseEntity.ok(service.existe(id));
    }

    @GetMapping("/compter")
    @Operation(summary = "Compter les parametre")
    public ResponseEntity<Long> compter() {
        return ResponseEntity.ok(service.compter());
    }
}
