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
import rmschoolapi.dto.basic.EtablissementScolaireBasicDTO;
import rmschoolapi.dto.full.EtablissementScolaireFullDTO;
import rmschoolapi.service.EtablissementScolaireService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/etablissement-scolaire")
@Tag(name = "EtablissementScolaire", description = "Gestion des etablissementScolaire")
public class EtablissementScolaireController {

    private final EtablissementScolaireService service;

    @PostMapping
    @Operation(summary = "CrÃ©er un etablissementScolaire (BasicDTO)")
    public ResponseEntity<EtablissementScolaireBasicDTO> creer(@RequestBody EtablissementScolaireBasicDTO basicDTO) {
        return new ResponseEntity<>(service.creer(basicDTO), HttpStatus.CREATED);
    }

    @PostMapping("/complet")
    @Operation(summary = "CrÃ©er un etablissementScolaire (FullDTO)")
    public ResponseEntity<EtablissementScolaireFullDTO> creerComplet(@RequestBody EtablissementScolaireFullDTO fullDTO) {
        return new ResponseEntity<>(service.creerComplet(fullDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtenir un etablissementScolaire par identifiant (FullDTO)")
    public ResponseEntity<EtablissementScolaireFullDTO> obtenirParId(@PathVariable @Parameter(description = "Identifiant") Long id) {
        return ResponseEntity.ok(service.obtenirParId(id));
    }

    @GetMapping("/{id}/basic")
    @Operation(summary = "Obtenir un etablissementScolaire par identifiant (BasicDTO)")
    public ResponseEntity<EtablissementScolaireBasicDTO> obtenirBasicParId(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenirBasicParId(id));
    }

    @GetMapping
    @Operation(summary = "Lister tous les etablissementScolaire (FullDTO)")
    public ResponseEntity<List<EtablissementScolaireFullDTO>> obtenirTous() {
        return ResponseEntity.ok(service.obtenirTous());
    }

    @GetMapping("/basic")
    @Operation(summary = "Lister tous les etablissementScolaire (BasicDTO)")
    public ResponseEntity<List<EtablissementScolaireBasicDTO>> obtenirTousBasic() {
        return ResponseEntity.ok(service.obtenirTousBasic());
    }

    @GetMapping("/page")
    @Operation(summary = "Lister tous les etablissementScolaire (paginÃ©)")
    public ResponseEntity<Page<EtablissementScolaireFullDTO>> obtenirTous(Pageable pageable) {
        return ResponseEntity.ok(service.obtenirTous(pageable));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier un etablissementScolaire (FullDTO)")
    public ResponseEntity<EtablissementScolaireFullDTO> modifier(@PathVariable Long id, @RequestBody EtablissementScolaireFullDTO fullDTO) {
        return ResponseEntity.ok(service.modifier(id, fullDTO));
    }

    @PutMapping("/{id}/basic")
    @Operation(summary = "Modifier un etablissementScolaire (BasicDTO)")
    public ResponseEntity<EtablissementScolaireBasicDTO> modifierBasic(@PathVariable Long id, @RequestBody EtablissementScolaireBasicDTO basicDTO) {
        return ResponseEntity.ok(service.modifierBasic(id, basicDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un etablissementScolaire")
    public ResponseEntity<Void> supprimer(@PathVariable Long id) {
        service.supprimer(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/existe")
    @Operation(summary = "VÃ©rifier l'existence d'un etablissementScolaire")
    public ResponseEntity<Boolean> existe(@PathVariable Long id) {
        return ResponseEntity.ok(service.existe(id));
    }

    @GetMapping("/compter")
    @Operation(summary = "Compter les etablissementScolaire")
    public ResponseEntity<Long> compter() {
        return ResponseEntity.ok(service.compter());
    }
}
