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
import rmschoolapi.dto.basic.DisciplineBasicDTO;
import rmschoolapi.dto.full.DisciplineFullDTO;
import rmschoolapi.service.DisciplineService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/discipline")
@Tag(name = "Discipline", description = "Gestion des discipline")
public class DisciplineController {

    private final DisciplineService service;

    @PostMapping
    @Operation(summary = "CrÃ©er un discipline (BasicDTO)")
    public ResponseEntity<DisciplineBasicDTO> creer(@RequestBody DisciplineBasicDTO basicDTO) {
        return new ResponseEntity<>(service.creer(basicDTO), HttpStatus.CREATED);
    }

    @PostMapping("/complet")
    @Operation(summary = "CrÃ©er un discipline (FullDTO)")
    public ResponseEntity<DisciplineFullDTO> creerComplet(@RequestBody DisciplineFullDTO fullDTO) {
        return new ResponseEntity<>(service.creerComplet(fullDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtenir un discipline par identifiant (FullDTO)")
    public ResponseEntity<DisciplineFullDTO> obtenirParId(@PathVariable @Parameter(description = "Identifiant") Long id) {
        return ResponseEntity.ok(service.obtenirParId(id));
    }

    @GetMapping("/{id}/basic")
    @Operation(summary = "Obtenir un discipline par identifiant (BasicDTO)")
    public ResponseEntity<DisciplineBasicDTO> obtenirBasicParId(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenirBasicParId(id));
    }

    @GetMapping
    @Operation(summary = "Lister tous les discipline (FullDTO)")
    public ResponseEntity<List<DisciplineFullDTO>> obtenirTous() {
        return ResponseEntity.ok(service.obtenirTous());
    }

    @GetMapping("/basic")
    @Operation(summary = "Lister tous les discipline (BasicDTO)")
    public ResponseEntity<List<DisciplineBasicDTO>> obtenirTousBasic() {
        return ResponseEntity.ok(service.obtenirTousBasic());
    }

    @GetMapping("/page")
    @Operation(summary = "Lister tous les discipline (paginÃ©)")
    public ResponseEntity<Page<DisciplineFullDTO>> obtenirTous(Pageable pageable) {
        return ResponseEntity.ok(service.obtenirTous(pageable));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier un discipline (FullDTO)")
    public ResponseEntity<DisciplineFullDTO> modifier(@PathVariable Long id, @RequestBody DisciplineFullDTO fullDTO) {
        return ResponseEntity.ok(service.modifier(id, fullDTO));
    }

    @PutMapping("/{id}/basic")
    @Operation(summary = "Modifier un discipline (BasicDTO)")
    public ResponseEntity<DisciplineBasicDTO> modifierBasic(@PathVariable Long id, @RequestBody DisciplineBasicDTO basicDTO) {
        return ResponseEntity.ok(service.modifierBasic(id, basicDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un discipline")
    public ResponseEntity<Void> supprimer(@PathVariable Long id) {
        service.supprimer(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/existe")
    @Operation(summary = "VÃ©rifier l'existence d'un discipline")
    public ResponseEntity<Boolean> existe(@PathVariable Long id) {
        return ResponseEntity.ok(service.existe(id));
    }

    @GetMapping("/compter")
    @Operation(summary = "Compter les discipline")
    public ResponseEntity<Long> compter() {
        return ResponseEntity.ok(service.compter());
    }
}
