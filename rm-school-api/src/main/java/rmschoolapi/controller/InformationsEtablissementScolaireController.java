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
import rmschoolapi.dto.basic.InformationsEtablissementScolaireBasicDTO;
import rmschoolapi.dto.full.InformationsEtablissementScolaireFullDTO;
import rmschoolapi.service.InformationsEtablissementScolaireService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/informations-etablissement-scolaire")
@Tag(name = "InformationsEtablissementScolaire", description = "Gestion des informationsEtablissementScolaire")
public class InformationsEtablissementScolaireController {

    private final InformationsEtablissementScolaireService service;

    @PostMapping
    @Operation(summary = "CrÃ©er un informationsEtablissementScolaire (BasicDTO)")
    public ResponseEntity<InformationsEtablissementScolaireBasicDTO> creer(@RequestBody InformationsEtablissementScolaireBasicDTO basicDTO) {
        return new ResponseEntity<>(service.creer(basicDTO), HttpStatus.CREATED);
    }

    @PostMapping("/complet")
    @Operation(summary = "CrÃ©er un informationsEtablissementScolaire (FullDTO)")
    public ResponseEntity<InformationsEtablissementScolaireFullDTO> creerComplet(@RequestBody InformationsEtablissementScolaireFullDTO fullDTO) {
        return new ResponseEntity<>(service.creerComplet(fullDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtenir un informationsEtablissementScolaire par identifiant (FullDTO)")
    public ResponseEntity<InformationsEtablissementScolaireFullDTO> obtenirParId(@PathVariable @Parameter(description = "Identifiant") Long id) {
        return ResponseEntity.ok(service.obtenirParId(id));
    }

    @GetMapping("/{id}/basic")
    @Operation(summary = "Obtenir un informationsEtablissementScolaire par identifiant (BasicDTO)")
    public ResponseEntity<InformationsEtablissementScolaireBasicDTO> obtenirBasicParId(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenirBasicParId(id));
    }

    @GetMapping
    @Operation(summary = "Lister tous les informationsEtablissementScolaire (FullDTO)")
    public ResponseEntity<List<InformationsEtablissementScolaireFullDTO>> obtenirTous() {
        return ResponseEntity.ok(service.obtenirTous());
    }

    @GetMapping("/basic")
    @Operation(summary = "Lister tous les informationsEtablissementScolaire (BasicDTO)")
    public ResponseEntity<List<InformationsEtablissementScolaireBasicDTO>> obtenirTousBasic() {
        return ResponseEntity.ok(service.obtenirTousBasic());
    }

    @GetMapping("/page")
    @Operation(summary = "Lister tous les informationsEtablissementScolaire (paginÃ©)")
    public ResponseEntity<Page<InformationsEtablissementScolaireFullDTO>> obtenirTous(Pageable pageable) {
        return ResponseEntity.ok(service.obtenirTous(pageable));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier un informationsEtablissementScolaire (FullDTO)")
    public ResponseEntity<InformationsEtablissementScolaireFullDTO> modifier(@PathVariable Long id, @RequestBody InformationsEtablissementScolaireFullDTO fullDTO) {
        return ResponseEntity.ok(service.modifier(id, fullDTO));
    }

    @PutMapping("/{id}/basic")
    @Operation(summary = "Modifier un informationsEtablissementScolaire (BasicDTO)")
    public ResponseEntity<InformationsEtablissementScolaireBasicDTO> modifierBasic(@PathVariable Long id, @RequestBody InformationsEtablissementScolaireBasicDTO basicDTO) {
        return ResponseEntity.ok(service.modifierBasic(id, basicDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un informationsEtablissementScolaire")
    public ResponseEntity<Void> supprimer(@PathVariable Long id) {
        service.supprimer(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/existe")
    @Operation(summary = "VÃ©rifier l'existence d'un informationsEtablissementScolaire")
    public ResponseEntity<Boolean> existe(@PathVariable Long id) {
        return ResponseEntity.ok(service.existe(id));
    }

    @GetMapping("/compter")
    @Operation(summary = "Compter les informationsEtablissementScolaire")
    public ResponseEntity<Long> compter() {
        return ResponseEntity.ok(service.compter());
    }
}
