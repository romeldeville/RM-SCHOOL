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
import rmschoolapi.dto.basic.StatutCompteUtilisateurBasicDTO;
import rmschoolapi.dto.full.StatutCompteUtilisateurFullDTO;
import rmschoolapi.service.StatutCompteUtilisateurService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/statut-compte-utilisateur")
@Tag(name = "StatutCompteUtilisateur", description = "Gestion des statutCompteUtilisateur")
public class StatutCompteUtilisateurController {

    private final StatutCompteUtilisateurService service;

    @PostMapping
    @Operation(summary = "CrÃ©er un statutCompteUtilisateur (BasicDTO)")
    public ResponseEntity<StatutCompteUtilisateurBasicDTO> creer(@RequestBody StatutCompteUtilisateurBasicDTO basicDTO) {
        return new ResponseEntity<>(service.creer(basicDTO), HttpStatus.CREATED);
    }

    @PostMapping("/complet")
    @Operation(summary = "CrÃ©er un statutCompteUtilisateur (FullDTO)")
    public ResponseEntity<StatutCompteUtilisateurFullDTO> creerComplet(@RequestBody StatutCompteUtilisateurFullDTO fullDTO) {
        return new ResponseEntity<>(service.creerComplet(fullDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtenir un statutCompteUtilisateur par identifiant (FullDTO)")
    public ResponseEntity<StatutCompteUtilisateurFullDTO> obtenirParId(@PathVariable @Parameter(description = "Identifiant") Long id) {
        return ResponseEntity.ok(service.obtenirParId(id));
    }

    @GetMapping("/{id}/basic")
    @Operation(summary = "Obtenir un statutCompteUtilisateur par identifiant (BasicDTO)")
    public ResponseEntity<StatutCompteUtilisateurBasicDTO> obtenirBasicParId(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenirBasicParId(id));
    }

    @GetMapping
    @Operation(summary = "Lister tous les statutCompteUtilisateur (FullDTO)")
    public ResponseEntity<List<StatutCompteUtilisateurFullDTO>> obtenirTous() {
        return ResponseEntity.ok(service.obtenirTous());
    }

    @GetMapping("/basic")
    @Operation(summary = "Lister tous les statutCompteUtilisateur (BasicDTO)")
    public ResponseEntity<List<StatutCompteUtilisateurBasicDTO>> obtenirTousBasic() {
        return ResponseEntity.ok(service.obtenirTousBasic());
    }

    @GetMapping("/page")
    @Operation(summary = "Lister tous les statutCompteUtilisateur (paginÃ©)")
    public ResponseEntity<Page<StatutCompteUtilisateurFullDTO>> obtenirTous(Pageable pageable) {
        return ResponseEntity.ok(service.obtenirTous(pageable));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier un statutCompteUtilisateur (FullDTO)")
    public ResponseEntity<StatutCompteUtilisateurFullDTO> modifier(@PathVariable Long id, @RequestBody StatutCompteUtilisateurFullDTO fullDTO) {
        return ResponseEntity.ok(service.modifier(id, fullDTO));
    }

    @PutMapping("/{id}/basic")
    @Operation(summary = "Modifier un statutCompteUtilisateur (BasicDTO)")
    public ResponseEntity<StatutCompteUtilisateurBasicDTO> modifierBasic(@PathVariable Long id, @RequestBody StatutCompteUtilisateurBasicDTO basicDTO) {
        return ResponseEntity.ok(service.modifierBasic(id, basicDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un statutCompteUtilisateur")
    public ResponseEntity<Void> supprimer(@PathVariable Long id) {
        service.supprimer(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/existe")
    @Operation(summary = "VÃ©rifier l'existence d'un statutCompteUtilisateur")
    public ResponseEntity<Boolean> existe(@PathVariable Long id) {
        return ResponseEntity.ok(service.existe(id));
    }

    @GetMapping("/compter")
    @Operation(summary = "Compter les statutCompteUtilisateur")
    public ResponseEntity<Long> compter() {
        return ResponseEntity.ok(service.compter());
    }
}
