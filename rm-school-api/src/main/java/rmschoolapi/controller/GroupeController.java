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
import rmschoolapi.dto.basic.GroupeBasicDTO;
import rmschoolapi.dto.full.GroupeFullDTO;
import rmschoolapi.service.GroupeService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/groupe")
@Tag(name = "Groupe", description = "Gestion des groupe")
public class GroupeController {

    private final GroupeService service;

    @PostMapping
    @Operation(summary = "CrÃ©er un groupe (BasicDTO)")
    public ResponseEntity<GroupeBasicDTO> creer(@RequestBody GroupeBasicDTO basicDTO) {
        return new ResponseEntity<>(service.creer(basicDTO), HttpStatus.CREATED);
    }

    @PostMapping("/complet")
    @Operation(summary = "CrÃ©er un groupe (FullDTO)")
    public ResponseEntity<GroupeFullDTO> creerComplet(@RequestBody GroupeFullDTO fullDTO) {
        return new ResponseEntity<>(service.creerComplet(fullDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtenir un groupe par identifiant (FullDTO)")
    public ResponseEntity<GroupeFullDTO> obtenirParId(@PathVariable @Parameter(description = "Identifiant") Long id) {
        return ResponseEntity.ok(service.obtenirParId(id));
    }

    @GetMapping("/{id}/basic")
    @Operation(summary = "Obtenir un groupe par identifiant (BasicDTO)")
    public ResponseEntity<GroupeBasicDTO> obtenirBasicParId(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenirBasicParId(id));
    }

    @GetMapping
    @Operation(summary = "Lister tous les groupe (FullDTO)")
    public ResponseEntity<List<GroupeFullDTO>> obtenirTous() {
        return ResponseEntity.ok(service.obtenirTous());
    }

    @GetMapping("/basic")
    @Operation(summary = "Lister tous les groupe (BasicDTO)")
    public ResponseEntity<List<GroupeBasicDTO>> obtenirTousBasic() {
        return ResponseEntity.ok(service.obtenirTousBasic());
    }

    @GetMapping("/page")
    @Operation(summary = "Lister tous les groupe (paginÃ©)")
    public ResponseEntity<Page<GroupeFullDTO>> obtenirTous(Pageable pageable) {
        return ResponseEntity.ok(service.obtenirTous(pageable));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier un groupe (FullDTO)")
    public ResponseEntity<GroupeFullDTO> modifier(@PathVariable Long id, @RequestBody GroupeFullDTO fullDTO) {
        return ResponseEntity.ok(service.modifier(id, fullDTO));
    }

    @PutMapping("/{id}/basic")
    @Operation(summary = "Modifier un groupe (BasicDTO)")
    public ResponseEntity<GroupeBasicDTO> modifierBasic(@PathVariable Long id, @RequestBody GroupeBasicDTO basicDTO) {
        return ResponseEntity.ok(service.modifierBasic(id, basicDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un groupe")
    public ResponseEntity<Void> supprimer(@PathVariable Long id) {
        service.supprimer(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/existe")
    @Operation(summary = "VÃ©rifier l'existence d'un groupe")
    public ResponseEntity<Boolean> existe(@PathVariable Long id) {
        return ResponseEntity.ok(service.existe(id));
    }

    @GetMapping("/compter")
    @Operation(summary = "Compter les groupe")
    public ResponseEntity<Long> compter() {
        return ResponseEntity.ok(service.compter());
    }
}
