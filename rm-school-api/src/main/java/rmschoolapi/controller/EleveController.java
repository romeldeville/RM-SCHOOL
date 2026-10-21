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
import rmschoolapi.dto.basic.EleveBasicDTO;
import rmschoolapi.dto.full.EleveFullDTO;
import rmschoolapi.service.EleveService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/eleve")
@Tag(name = "Eleve", description = "Gestion des eleve")
public class EleveController {

    private final EleveService service;

    @PostMapping
    @Operation(summary = "CrÃ©er un eleve (BasicDTO)")
    public ResponseEntity<EleveBasicDTO> creer(@RequestBody EleveBasicDTO basicDTO) {
        return new ResponseEntity<>(service.creer(basicDTO), HttpStatus.CREATED);
    }

    @PostMapping("/complet")
    @Operation(summary = "CrÃ©er un eleve (FullDTO)")
    public ResponseEntity<EleveFullDTO> creerComplet(@RequestBody EleveFullDTO fullDTO) {
        return new ResponseEntity<>(service.creerComplet(fullDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtenir un eleve par identifiant (FullDTO)")
    public ResponseEntity<EleveFullDTO> obtenirParId(@PathVariable @Parameter(description = "Identifiant") Long id) {
        return ResponseEntity.ok(service.obtenirParId(id));
    }

    @GetMapping("/{id}/basic")
    @Operation(summary = "Obtenir un eleve par identifiant (BasicDTO)")
    public ResponseEntity<EleveBasicDTO> obtenirBasicParId(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenirBasicParId(id));
    }

    @GetMapping
    @Operation(summary = "Lister tous les eleve (FullDTO)")
    public ResponseEntity<List<EleveFullDTO>> obtenirTous() {
        return ResponseEntity.ok(service.obtenirTous());
    }

    @GetMapping("/basic")
    @Operation(summary = "Lister tous les eleve (BasicDTO)")
    public ResponseEntity<List<EleveBasicDTO>> obtenirTousBasic() {
        return ResponseEntity.ok(service.obtenirTousBasic());
    }

    @GetMapping("/page")
    @Operation(summary = "Lister tous les eleve (paginÃ©)")
    public ResponseEntity<Page<EleveFullDTO>> obtenirTous(Pageable pageable) {
        return ResponseEntity.ok(service.obtenirTous(pageable));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier un eleve (FullDTO)")
    public ResponseEntity<EleveFullDTO> modifier(@PathVariable Long id, @RequestBody EleveFullDTO fullDTO) {
        return ResponseEntity.ok(service.modifier(id, fullDTO));
    }

    @PutMapping("/{id}/basic")
    @Operation(summary = "Modifier un eleve (BasicDTO)")
    public ResponseEntity<EleveBasicDTO> modifierBasic(@PathVariable Long id, @RequestBody EleveBasicDTO basicDTO) {
        return ResponseEntity.ok(service.modifierBasic(id, basicDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un eleve")
    public ResponseEntity<Void> supprimer(@PathVariable Long id) {
        service.supprimer(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/existe")
    @Operation(summary = "VÃ©rifier l'existence d'un eleve")
    public ResponseEntity<Boolean> existe(@PathVariable Long id) {
        return ResponseEntity.ok(service.existe(id));
    }

    @GetMapping("/compter")
    @Operation(summary = "Compter les eleve")
    public ResponseEntity<Long> compter() {
        return ResponseEntity.ok(service.compter());
    }
}
