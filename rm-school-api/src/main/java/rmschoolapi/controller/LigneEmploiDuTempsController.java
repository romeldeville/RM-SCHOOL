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
import rmschoolapi.dto.basic.LigneEmploiDuTempsBasicDTO;
import rmschoolapi.dto.full.LigneEmploiDuTempsFullDTO;
import rmschoolapi.service.LigneEmploiDuTempsService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/ligne-emploi-du-temps")
@Tag(name = "LigneEmploiDuTemps", description = "Gestion des ligneEmploiDuTemps")
public class LigneEmploiDuTempsController {

    private final LigneEmploiDuTempsService service;

    @PostMapping
    @Operation(summary = "CrÃ©er un ligneEmploiDuTemps (BasicDTO)")
    public ResponseEntity<LigneEmploiDuTempsBasicDTO> creer(@RequestBody LigneEmploiDuTempsBasicDTO basicDTO) {
        return new ResponseEntity<>(service.creer(basicDTO), HttpStatus.CREATED);
    }

    @PostMapping("/complet")
    @Operation(summary = "CrÃ©er un ligneEmploiDuTemps (FullDTO)")
    public ResponseEntity<LigneEmploiDuTempsFullDTO> creerComplet(@RequestBody LigneEmploiDuTempsFullDTO fullDTO) {
        return new ResponseEntity<>(service.creerComplet(fullDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtenir un ligneEmploiDuTemps par identifiant (FullDTO)")
    public ResponseEntity<LigneEmploiDuTempsFullDTO> obtenirParId(@PathVariable @Parameter(description = "Identifiant") Long id) {
        return ResponseEntity.ok(service.obtenirParId(id));
    }

    @GetMapping("/{id}/basic")
    @Operation(summary = "Obtenir un ligneEmploiDuTemps par identifiant (BasicDTO)")
    public ResponseEntity<LigneEmploiDuTempsBasicDTO> obtenirBasicParId(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenirBasicParId(id));
    }

    @GetMapping
    @Operation(summary = "Lister tous les ligneEmploiDuTemps (FullDTO)")
    public ResponseEntity<List<LigneEmploiDuTempsFullDTO>> obtenirTous() {
        return ResponseEntity.ok(service.obtenirTous());
    }

    @GetMapping("/basic")
    @Operation(summary = "Lister tous les ligneEmploiDuTemps (BasicDTO)")
    public ResponseEntity<List<LigneEmploiDuTempsBasicDTO>> obtenirTousBasic() {
        return ResponseEntity.ok(service.obtenirTousBasic());
    }

    @GetMapping("/page")
    @Operation(summary = "Lister tous les ligneEmploiDuTemps (paginÃ©)")
    public ResponseEntity<Page<LigneEmploiDuTempsFullDTO>> obtenirTous(Pageable pageable) {
        return ResponseEntity.ok(service.obtenirTous(pageable));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier un ligneEmploiDuTemps (FullDTO)")
    public ResponseEntity<LigneEmploiDuTempsFullDTO> modifier(@PathVariable Long id, @RequestBody LigneEmploiDuTempsFullDTO fullDTO) {
        return ResponseEntity.ok(service.modifier(id, fullDTO));
    }

    @PutMapping("/{id}/basic")
    @Operation(summary = "Modifier un ligneEmploiDuTemps (BasicDTO)")
    public ResponseEntity<LigneEmploiDuTempsBasicDTO> modifierBasic(@PathVariable Long id, @RequestBody LigneEmploiDuTempsBasicDTO basicDTO) {
        return ResponseEntity.ok(service.modifierBasic(id, basicDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un ligneEmploiDuTemps")
    public ResponseEntity<Void> supprimer(@PathVariable Long id) {
        service.supprimer(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/existe")
    @Operation(summary = "VÃ©rifier l'existence d'un ligneEmploiDuTemps")
    public ResponseEntity<Boolean> existe(@PathVariable Long id) {
        return ResponseEntity.ok(service.existe(id));
    }

    @GetMapping("/compter")
    @Operation(summary = "Compter les ligneEmploiDuTemps")
    public ResponseEntity<Long> compter() {
        return ResponseEntity.ok(service.compter());
    }
}
