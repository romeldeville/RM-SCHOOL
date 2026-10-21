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
import rmschoolapi.dto.basic.MatiereBasicDTO;
import rmschoolapi.dto.full.MatiereFullDTO;
import rmschoolapi.service.MatiereService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/matiere")
@Tag(name = "Matiere", description = "Gestion des matiere")
public class MatiereController {

    private final MatiereService service;

    @PostMapping
    @Operation(summary = "CrÃ©er un matiere (BasicDTO)")
    public ResponseEntity<MatiereBasicDTO> creer(@RequestBody MatiereBasicDTO basicDTO) {
        return new ResponseEntity<>(service.creer(basicDTO), HttpStatus.CREATED);
    }

    @PostMapping("/complet")
    @Operation(summary = "CrÃ©er un matiere (FullDTO)")
    public ResponseEntity<MatiereFullDTO> creerComplet(@RequestBody MatiereFullDTO fullDTO) {
        return new ResponseEntity<>(service.creerComplet(fullDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtenir un matiere par identifiant (FullDTO)")
    public ResponseEntity<MatiereFullDTO> obtenirParId(@PathVariable @Parameter(description = "Identifiant") Long id) {
        return ResponseEntity.ok(service.obtenirParId(id));
    }

    @GetMapping("/{id}/basic")
    @Operation(summary = "Obtenir un matiere par identifiant (BasicDTO)")
    public ResponseEntity<MatiereBasicDTO> obtenirBasicParId(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenirBasicParId(id));
    }

    @GetMapping
    @Operation(summary = "Lister tous les matiere (FullDTO)")
    public ResponseEntity<List<MatiereFullDTO>> obtenirTous() {
        return ResponseEntity.ok(service.obtenirTous());
    }

    @GetMapping("/basic")
    @Operation(summary = "Lister tous les matiere (BasicDTO)")
    public ResponseEntity<List<MatiereBasicDTO>> obtenirTousBasic() {
        return ResponseEntity.ok(service.obtenirTousBasic());
    }

    @GetMapping("/page")
    @Operation(summary = "Lister tous les matiere (paginÃ©)")
    public ResponseEntity<Page<MatiereFullDTO>> obtenirTous(Pageable pageable) {
        return ResponseEntity.ok(service.obtenirTous(pageable));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier un matiere (FullDTO)")
    public ResponseEntity<MatiereFullDTO> modifier(@PathVariable Long id, @RequestBody MatiereFullDTO fullDTO) {
        return ResponseEntity.ok(service.modifier(id, fullDTO));
    }

    @PutMapping("/{id}/basic")
    @Operation(summary = "Modifier un matiere (BasicDTO)")
    public ResponseEntity<MatiereBasicDTO> modifierBasic(@PathVariable Long id, @RequestBody MatiereBasicDTO basicDTO) {
        return ResponseEntity.ok(service.modifierBasic(id, basicDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un matiere")
    public ResponseEntity<Void> supprimer(@PathVariable Long id) {
        service.supprimer(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/existe")
    @Operation(summary = "VÃ©rifier l'existence d'un matiere")
    public ResponseEntity<Boolean> existe(@PathVariable Long id) {
        return ResponseEntity.ok(service.existe(id));
    }

    @GetMapping("/compter")
    @Operation(summary = "Compter les matiere")
    public ResponseEntity<Long> compter() {
        return ResponseEntity.ok(service.compter());
    }
}
