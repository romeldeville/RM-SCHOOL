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
import rmschoolapi.dto.basic.CompteUtilisateurBasicDTO;
import rmschoolapi.dto.full.CompteUtilisateurFullDTO;
import rmschoolapi.service.CompteUtilisateurService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/compte-utilisateur")
@Tag(name = "CompteUtilisateur", description = "Gestion des compteUtilisateur")
public class CompteUtilisateurController {

    private final CompteUtilisateurService service;

    @PostMapping
    @Operation(summary = "CrÃ©er un compteUtilisateur (BasicDTO)")
    public ResponseEntity<CompteUtilisateurBasicDTO> creer(@RequestBody CompteUtilisateurBasicDTO basicDTO) {
        return new ResponseEntity<>(service.creer(basicDTO), HttpStatus.CREATED);
    }

    @PostMapping("/complet")
    @Operation(summary = "CrÃ©er un compteUtilisateur (FullDTO)")
    public ResponseEntity<CompteUtilisateurFullDTO> creerComplet(@RequestBody CompteUtilisateurFullDTO fullDTO) {
        return new ResponseEntity<>(service.creerComplet(fullDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtenir un compteUtilisateur par identifiant (FullDTO)")
    public ResponseEntity<CompteUtilisateurFullDTO> obtenirParId(@PathVariable @Parameter(description = "Identifiant") Long id) {
        return ResponseEntity.ok(service.obtenirParId(id));
    }

    @GetMapping("/{id}/basic")
    @Operation(summary = "Obtenir un compteUtilisateur par identifiant (BasicDTO)")
    public ResponseEntity<CompteUtilisateurBasicDTO> obtenirBasicParId(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenirBasicParId(id));
    }

    @GetMapping
    @Operation(summary = "Lister tous les compteUtilisateur (FullDTO)")
    public ResponseEntity<List<CompteUtilisateurFullDTO>> obtenirTous() {
        return ResponseEntity.ok(service.obtenirTous());
    }

    @GetMapping("/basic")
    @Operation(summary = "Lister tous les compteUtilisateur (BasicDTO)")
    public ResponseEntity<List<CompteUtilisateurBasicDTO>> obtenirTousBasic() {
        return ResponseEntity.ok(service.obtenirTousBasic());
    }

    @GetMapping("/page")
    @Operation(summary = "Lister tous les compteUtilisateur (paginÃ©)")
    public ResponseEntity<Page<CompteUtilisateurFullDTO>> obtenirTous(Pageable pageable) {
        return ResponseEntity.ok(service.obtenirTous(pageable));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier un compteUtilisateur (FullDTO)")
    public ResponseEntity<CompteUtilisateurFullDTO> modifier(@PathVariable Long id, @RequestBody CompteUtilisateurFullDTO fullDTO) {
        return ResponseEntity.ok(service.modifier(id, fullDTO));
    }

    @PutMapping("/{id}/basic")
    @Operation(summary = "Modifier un compteUtilisateur (BasicDTO)")
    public ResponseEntity<CompteUtilisateurBasicDTO> modifierBasic(@PathVariable Long id, @RequestBody CompteUtilisateurBasicDTO basicDTO) {
        return ResponseEntity.ok(service.modifierBasic(id, basicDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un compteUtilisateur")
    public ResponseEntity<Void> supprimer(@PathVariable Long id) {
        service.supprimer(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/existe")
    @Operation(summary = "VÃ©rifier l'existence d'un compteUtilisateur")
    public ResponseEntity<Boolean> existe(@PathVariable Long id) {
        return ResponseEntity.ok(service.existe(id));
    }

    @GetMapping("/compter")
    @Operation(summary = "Compter les compteUtilisateur")
    public ResponseEntity<Long> compter() {
        return ResponseEntity.ok(service.compter());
    }
}
