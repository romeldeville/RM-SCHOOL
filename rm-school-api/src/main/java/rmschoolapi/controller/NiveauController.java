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
import rmschoolapi.dto.basic.NiveauBasicDTO;
import rmschoolapi.dto.full.NiveauFullDTO;
import rmschoolapi.service.NiveauService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/niveau")
@Tag(name = "Niveau", description = "Gestion des niveau")
public class NiveauController {

    private final NiveauService service;

    @PostMapping
    @Operation(summary = "CrÃ©er un niveau (BasicDTO)")
    public ResponseEntity<NiveauBasicDTO> creer(@RequestBody NiveauBasicDTO basicDTO) {
        return new ResponseEntity<>(service.creer(basicDTO), HttpStatus.CREATED);
    }

    @PostMapping("/complet")
    @Operation(summary = "CrÃ©er un niveau (FullDTO)")
    public ResponseEntity<NiveauFullDTO> creerComplet(@RequestBody NiveauFullDTO fullDTO) {
        return new ResponseEntity<>(service.creerComplet(fullDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtenir un niveau par identifiant (FullDTO)")
    public ResponseEntity<NiveauFullDTO> obtenirParId(@PathVariable @Parameter(description = "Identifiant") Long id) {
        return ResponseEntity.ok(service.obtenirParId(id));
    }

    @GetMapping("/{id}/basic")
    @Operation(summary = "Obtenir un niveau par identifiant (BasicDTO)")
    public ResponseEntity<NiveauBasicDTO> obtenirBasicParId(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenirBasicParId(id));
    }

    @GetMapping
    @Operation(summary = "Lister tous les niveau (FullDTO)")
    public ResponseEntity<List<NiveauFullDTO>> obtenirTous() {
        return ResponseEntity.ok(service.obtenirTous());
    }

    @GetMapping("/basic")
    @Operation(summary = "Lister tous les niveau (BasicDTO)")
    public ResponseEntity<List<NiveauBasicDTO>> obtenirTousBasic() {
        return ResponseEntity.ok(service.obtenirTousBasic());
    }

    @GetMapping("/page")
    @Operation(summary = "Lister tous les niveau (paginÃ©)")
    public ResponseEntity<Page<NiveauFullDTO>> obtenirTous(Pageable pageable) {
        return ResponseEntity.ok(service.obtenirTous(pageable));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier un niveau (FullDTO)")
    public ResponseEntity<NiveauFullDTO> modifier(@PathVariable Long id, @RequestBody NiveauFullDTO fullDTO) {
        return ResponseEntity.ok(service.modifier(id, fullDTO));
    }

    @PutMapping("/{id}/basic")
    @Operation(summary = "Modifier un niveau (BasicDTO)")
    public ResponseEntity<NiveauBasicDTO> modifierBasic(@PathVariable Long id, @RequestBody NiveauBasicDTO basicDTO) {
        return ResponseEntity.ok(service.modifierBasic(id, basicDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un niveau")
    public ResponseEntity<Void> supprimer(@PathVariable Long id) {
        service.supprimer(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/existe")
    @Operation(summary = "VÃ©rifier l'existence d'un niveau")
    public ResponseEntity<Boolean> existe(@PathVariable Long id) {
        return ResponseEntity.ok(service.existe(id));
    }

    @GetMapping("/compter")
    @Operation(summary = "Compter les niveau")
    public ResponseEntity<Long> compter() {
        return ResponseEntity.ok(service.compter());
    }
}
