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
import rmschoolapi.dto.basic.TypeCreneauBasicDTO;
import rmschoolapi.dto.full.TypeCreneauFullDTO;
import rmschoolapi.service.TypeCreneauService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/type-creneau")
@Tag(name = "TypeCreneau", description = "Gestion des typeCreneau")
public class TypeCreneauController {

    private final TypeCreneauService service;

    @PostMapping
    @Operation(summary = "CrÃ©er un typeCreneau (BasicDTO)")
    public ResponseEntity<TypeCreneauBasicDTO> creer(@RequestBody TypeCreneauBasicDTO basicDTO) {
        return new ResponseEntity<>(service.creer(basicDTO), HttpStatus.CREATED);
    }

    @PostMapping("/complet")
    @Operation(summary = "CrÃ©er un typeCreneau (FullDTO)")
    public ResponseEntity<TypeCreneauFullDTO> creerComplet(@RequestBody TypeCreneauFullDTO fullDTO) {
        return new ResponseEntity<>(service.creerComplet(fullDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtenir un typeCreneau par identifiant (FullDTO)")
    public ResponseEntity<TypeCreneauFullDTO> obtenirParId(@PathVariable @Parameter(description = "Identifiant") Long id) {
        return ResponseEntity.ok(service.obtenirParId(id));
    }

    @GetMapping("/{id}/basic")
    @Operation(summary = "Obtenir un typeCreneau par identifiant (BasicDTO)")
    public ResponseEntity<TypeCreneauBasicDTO> obtenirBasicParId(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenirBasicParId(id));
    }

    @GetMapping
    @Operation(summary = "Lister tous les typeCreneau (FullDTO)")
    public ResponseEntity<List<TypeCreneauFullDTO>> obtenirTous() {
        return ResponseEntity.ok(service.obtenirTous());
    }

    @GetMapping("/basic")
    @Operation(summary = "Lister tous les typeCreneau (BasicDTO)")
    public ResponseEntity<List<TypeCreneauBasicDTO>> obtenirTousBasic() {
        return ResponseEntity.ok(service.obtenirTousBasic());
    }

    @GetMapping("/page")
    @Operation(summary = "Lister tous les typeCreneau (paginÃ©)")
    public ResponseEntity<Page<TypeCreneauFullDTO>> obtenirTous(Pageable pageable) {
        return ResponseEntity.ok(service.obtenirTous(pageable));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier un typeCreneau (FullDTO)")
    public ResponseEntity<TypeCreneauFullDTO> modifier(@PathVariable Long id, @RequestBody TypeCreneauFullDTO fullDTO) {
        return ResponseEntity.ok(service.modifier(id, fullDTO));
    }

    @PutMapping("/{id}/basic")
    @Operation(summary = "Modifier un typeCreneau (BasicDTO)")
    public ResponseEntity<TypeCreneauBasicDTO> modifierBasic(@PathVariable Long id, @RequestBody TypeCreneauBasicDTO basicDTO) {
        return ResponseEntity.ok(service.modifierBasic(id, basicDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un typeCreneau")
    public ResponseEntity<Void> supprimer(@PathVariable Long id) {
        service.supprimer(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/existe")
    @Operation(summary = "VÃ©rifier l'existence d'un typeCreneau")
    public ResponseEntity<Boolean> existe(@PathVariable Long id) {
        return ResponseEntity.ok(service.existe(id));
    }

    @GetMapping("/compter")
    @Operation(summary = "Compter les typeCreneau")
    public ResponseEntity<Long> compter() {
        return ResponseEntity.ok(service.compter());
    }
}
