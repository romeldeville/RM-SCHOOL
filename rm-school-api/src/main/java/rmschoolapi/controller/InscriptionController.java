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
import rmschoolapi.dto.basic.InscriptionBasicDTO;
import rmschoolapi.dto.full.InscriptionFullDTO;
import rmschoolapi.service.InscriptionService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/inscription")
@Tag(name = "Inscription", description = "Gestion des inscription")
public class InscriptionController {

    private final InscriptionService service;

    @PostMapping
    @Operation(summary = "CrÃ©er un inscription (BasicDTO)")
    public ResponseEntity<InscriptionBasicDTO> creer(@RequestBody InscriptionBasicDTO basicDTO) {
        return new ResponseEntity<>(service.creer(basicDTO), HttpStatus.CREATED);
    }

    @PostMapping("/complet")
    @Operation(summary = "CrÃ©er un inscription (FullDTO)")
    public ResponseEntity<InscriptionFullDTO> creerComplet(@RequestBody InscriptionFullDTO fullDTO) {
        return new ResponseEntity<>(service.creerComplet(fullDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtenir un inscription par identifiant (FullDTO)")
    public ResponseEntity<InscriptionFullDTO> obtenirParId(@PathVariable @Parameter(description = "Identifiant") Long id) {
        return ResponseEntity.ok(service.obtenirParId(id));
    }

    @GetMapping("/{id}/basic")
    @Operation(summary = "Obtenir un inscription par identifiant (BasicDTO)")
    public ResponseEntity<InscriptionBasicDTO> obtenirBasicParId(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenirBasicParId(id));
    }

    @GetMapping
    @Operation(summary = "Lister tous les inscription (FullDTO)")
    public ResponseEntity<List<InscriptionFullDTO>> obtenirTous() {
        return ResponseEntity.ok(service.obtenirTous());
    }

    @GetMapping("/basic")
    @Operation(summary = "Lister tous les inscription (BasicDTO)")
    public ResponseEntity<List<InscriptionBasicDTO>> obtenirTousBasic() {
        return ResponseEntity.ok(service.obtenirTousBasic());
    }

    @GetMapping("/page")
    @Operation(summary = "Lister tous les inscription (paginÃ©)")
    public ResponseEntity<Page<InscriptionFullDTO>> obtenirTous(Pageable pageable) {
        return ResponseEntity.ok(service.obtenirTous(pageable));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier un inscription (FullDTO)")
    public ResponseEntity<InscriptionFullDTO> modifier(@PathVariable Long id, @RequestBody InscriptionFullDTO fullDTO) {
        return ResponseEntity.ok(service.modifier(id, fullDTO));
    }

    @PutMapping("/{id}/basic")
    @Operation(summary = "Modifier un inscription (BasicDTO)")
    public ResponseEntity<InscriptionBasicDTO> modifierBasic(@PathVariable Long id, @RequestBody InscriptionBasicDTO basicDTO) {
        return ResponseEntity.ok(service.modifierBasic(id, basicDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un inscription")
    public ResponseEntity<Void> supprimer(@PathVariable Long id) {
        service.supprimer(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/existe")
    @Operation(summary = "VÃ©rifier l'existence d'un inscription")
    public ResponseEntity<Boolean> existe(@PathVariable Long id) {
        return ResponseEntity.ok(service.existe(id));
    }

    @GetMapping("/compter")
    @Operation(summary = "Compter les inscription")
    public ResponseEntity<Long> compter() {
        return ResponseEntity.ok(service.compter());
    }
}
