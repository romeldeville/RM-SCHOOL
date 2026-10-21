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
import rmschoolapi.dto.basic.CourNiveauBasicDTO;
import rmschoolapi.dto.full.CourNiveauFullDTO;
import rmschoolapi.service.CourNiveauService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cour-niveau")
@Tag(name = "CourNiveau", description = "Gestion des courNiveau")
public class CourNiveauController {

    private final CourNiveauService service;

    @PostMapping
    @Operation(summary = "CrÃ©er un courNiveau (BasicDTO)")
    public ResponseEntity<CourNiveauBasicDTO> creer(@RequestBody CourNiveauBasicDTO basicDTO) {
        return new ResponseEntity<>(service.creer(basicDTO), HttpStatus.CREATED);
    }

    @PostMapping("/complet")
    @Operation(summary = "CrÃ©er un courNiveau (FullDTO)")
    public ResponseEntity<CourNiveauFullDTO> creerComplet(@RequestBody CourNiveauFullDTO fullDTO) {
        return new ResponseEntity<>(service.creerComplet(fullDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtenir un courNiveau par identifiant (FullDTO)")
    public ResponseEntity<CourNiveauFullDTO> obtenirParId(@PathVariable @Parameter(description = "Identifiant") Long id) {
        return ResponseEntity.ok(service.obtenirParId(id));
    }

    @GetMapping("/{id}/basic")
    @Operation(summary = "Obtenir un courNiveau par identifiant (BasicDTO)")
    public ResponseEntity<CourNiveauBasicDTO> obtenirBasicParId(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenirBasicParId(id));
    }

    @GetMapping
    @Operation(summary = "Lister tous les courNiveau (FullDTO)")
    public ResponseEntity<List<CourNiveauFullDTO>> obtenirTous() {
        return ResponseEntity.ok(service.obtenirTous());
    }

    @GetMapping("/basic")
    @Operation(summary = "Lister tous les courNiveau (BasicDTO)")
    public ResponseEntity<List<CourNiveauBasicDTO>> obtenirTousBasic() {
        return ResponseEntity.ok(service.obtenirTousBasic());
    }

    @GetMapping("/page")
    @Operation(summary = "Lister tous les courNiveau (paginÃ©)")
    public ResponseEntity<Page<CourNiveauFullDTO>> obtenirTous(Pageable pageable) {
        return ResponseEntity.ok(service.obtenirTous(pageable));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier un courNiveau (FullDTO)")
    public ResponseEntity<CourNiveauFullDTO> modifier(@PathVariable Long id, @RequestBody CourNiveauFullDTO fullDTO) {
        return ResponseEntity.ok(service.modifier(id, fullDTO));
    }

    @PutMapping("/{id}/basic")
    @Operation(summary = "Modifier un courNiveau (BasicDTO)")
    public ResponseEntity<CourNiveauBasicDTO> modifierBasic(@PathVariable Long id, @RequestBody CourNiveauBasicDTO basicDTO) {
        return ResponseEntity.ok(service.modifierBasic(id, basicDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un courNiveau")
    public ResponseEntity<Void> supprimer(@PathVariable Long id) {
        service.supprimer(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/existe")
    @Operation(summary = "VÃ©rifier l'existence d'un courNiveau")
    public ResponseEntity<Boolean> existe(@PathVariable Long id) {
        return ResponseEntity.ok(service.existe(id));
    }

    @GetMapping("/compter")
    @Operation(summary = "Compter les courNiveau")
    public ResponseEntity<Long> compter() {
        return ResponseEntity.ok(service.compter());
    }
}
