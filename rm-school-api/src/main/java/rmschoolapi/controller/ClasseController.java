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
import rmschoolapi.dto.basic.ClasseBasicDTO;
import rmschoolapi.dto.full.ClasseFullDTO;
import rmschoolapi.service.ClasseService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/classe")
@Tag(name = "Classe", description = "Gestion des classe")
public class ClasseController {

    private final ClasseService service;

    @PostMapping
    @Operation(summary = "CrÃ©er un classe (BasicDTO)")
    public ResponseEntity<ClasseBasicDTO> creer(@RequestBody ClasseBasicDTO basicDTO) {
        return new ResponseEntity<>(service.creer(basicDTO), HttpStatus.CREATED);
    }

    @PostMapping("/complet")
    @Operation(summary = "CrÃ©er un classe (FullDTO)")
    public ResponseEntity<ClasseFullDTO> creerComplet(@RequestBody ClasseFullDTO fullDTO) {
        return new ResponseEntity<>(service.creerComplet(fullDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtenir un classe par identifiant (FullDTO)")
    public ResponseEntity<ClasseFullDTO> obtenirParId(@PathVariable @Parameter(description = "Identifiant") Long id) {
        return ResponseEntity.ok(service.obtenirParId(id));
    }

    @GetMapping("/{id}/basic")
    @Operation(summary = "Obtenir un classe par identifiant (BasicDTO)")
    public ResponseEntity<ClasseBasicDTO> obtenirBasicParId(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenirBasicParId(id));
    }

    @GetMapping
    @Operation(summary = "Lister tous les classe (FullDTO)")
    public ResponseEntity<List<ClasseFullDTO>> obtenirTous() {
        return ResponseEntity.ok(service.obtenirTous());
    }

    @GetMapping("/basic")
    @Operation(summary = "Lister tous les classe (BasicDTO)")
    public ResponseEntity<List<ClasseBasicDTO>> obtenirTousBasic() {
        return ResponseEntity.ok(service.obtenirTousBasic());
    }

    @GetMapping("/page")
    @Operation(summary = "Lister tous les classe (paginÃ©)")
    public ResponseEntity<Page<ClasseFullDTO>> obtenirTous(Pageable pageable) {
        return ResponseEntity.ok(service.obtenirTous(pageable));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier un classe (FullDTO)")
    public ResponseEntity<ClasseFullDTO> modifier(@PathVariable Long id, @RequestBody ClasseFullDTO fullDTO) {
        return ResponseEntity.ok(service.modifier(id, fullDTO));
    }

    @PutMapping("/{id}/basic")
    @Operation(summary = "Modifier un classe (BasicDTO)")
    public ResponseEntity<ClasseBasicDTO> modifierBasic(@PathVariable Long id, @RequestBody ClasseBasicDTO basicDTO) {
        return ResponseEntity.ok(service.modifierBasic(id, basicDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un classe")
    public ResponseEntity<Void> supprimer(@PathVariable Long id) {
        service.supprimer(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/existe")
    @Operation(summary = "VÃ©rifier l'existence d'un classe")
    public ResponseEntity<Boolean> existe(@PathVariable Long id) {
        return ResponseEntity.ok(service.existe(id));
    }

    @GetMapping("/compter")
    @Operation(summary = "Compter les classe")
    public ResponseEntity<Long> compter() {
        return ResponseEntity.ok(service.compter());
    }
}
