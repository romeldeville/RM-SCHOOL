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
import rmschoolapi.dto.basic.AnneeScolaireBasicDTO;
import rmschoolapi.dto.full.AnneeScolaireFullDTO;
import rmschoolapi.service.AnneeScolaireService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/annee-scolaire")
@Tag(name = "AnneeScolaire", description = "Gestion des anneeScolaire")
public class AnneeScolaireController {

    private final AnneeScolaireService service;

    @PostMapping
    @Operation(summary = "CrÃ©er un anneeScolaire (BasicDTO)")
    public ResponseEntity<AnneeScolaireBasicDTO> creer(@RequestBody AnneeScolaireBasicDTO basicDTO) {
        return new ResponseEntity<>(service.creer(basicDTO), HttpStatus.CREATED);
    }

    @PostMapping("/complet")
    @Operation(summary = "CrÃ©er un anneeScolaire (FullDTO)")
    public ResponseEntity<AnneeScolaireFullDTO> creerComplet(@RequestBody AnneeScolaireFullDTO fullDTO) {
        return new ResponseEntity<>(service.creerComplet(fullDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtenir un anneeScolaire par identifiant (FullDTO)")
    public ResponseEntity<AnneeScolaireFullDTO> obtenirParId(@PathVariable @Parameter(description = "Identifiant") Long id) {
        return ResponseEntity.ok(service.obtenirParId(id));
    }

    @GetMapping("/{id}/basic")
    @Operation(summary = "Obtenir un anneeScolaire par identifiant (BasicDTO)")
    public ResponseEntity<AnneeScolaireBasicDTO> obtenirBasicParId(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenirBasicParId(id));
    }

    @GetMapping
    @Operation(summary = "Lister tous les anneeScolaire (FullDTO)")
    public ResponseEntity<List<AnneeScolaireFullDTO>> obtenirTous() {
        return ResponseEntity.ok(service.obtenirTous());
    }

    @GetMapping("/basic")
    @Operation(summary = "Lister tous les anneeScolaire (BasicDTO)")
    public ResponseEntity<List<AnneeScolaireBasicDTO>> obtenirTousBasic() {
        return ResponseEntity.ok(service.obtenirTousBasic());
    }

    @GetMapping("/page")
    @Operation(summary = "Lister tous les anneeScolaire (paginÃ©)")
    public ResponseEntity<Page<AnneeScolaireFullDTO>> obtenirTous(Pageable pageable) {
        return ResponseEntity.ok(service.obtenirTous(pageable));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier un anneeScolaire (FullDTO)")
    public ResponseEntity<AnneeScolaireFullDTO> modifier(@PathVariable Long id, @RequestBody AnneeScolaireFullDTO fullDTO) {
        return ResponseEntity.ok(service.modifier(id, fullDTO));
    }

    @PutMapping("/{id}/basic")
    @Operation(summary = "Modifier un anneeScolaire (BasicDTO)")
    public ResponseEntity<AnneeScolaireBasicDTO> modifierBasic(@PathVariable Long id, @RequestBody AnneeScolaireBasicDTO basicDTO) {
        return ResponseEntity.ok(service.modifierBasic(id, basicDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un anneeScolaire")
    public ResponseEntity<Void> supprimer(@PathVariable Long id) {
        service.supprimer(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/existe")
    @Operation(summary = "VÃ©rifier l'existence d'un anneeScolaire")
    public ResponseEntity<Boolean> existe(@PathVariable Long id) {
        return ResponseEntity.ok(service.existe(id));
    }

    @GetMapping("/compter")
    @Operation(summary = "Compter les anneeScolaire")
    public ResponseEntity<Long> compter() {
        return ResponseEntity.ok(service.compter());
    }
}
