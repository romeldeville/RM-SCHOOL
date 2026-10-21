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
import rmschoolapi.dto.basic.JourSemaineBasicDTO;
import rmschoolapi.dto.full.JourSemaineFullDTO;
import rmschoolapi.service.JourSemaineService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/jour-semaine")
@Tag(name = "JourSemaine", description = "Gestion des jourSemaine")
public class JourSemaineController {

    private final JourSemaineService service;

    @PostMapping
    @Operation(summary = "CrÃ©er un jourSemaine (BasicDTO)")
    public ResponseEntity<JourSemaineBasicDTO> creer(@RequestBody JourSemaineBasicDTO basicDTO) {
        return new ResponseEntity<>(service.creer(basicDTO), HttpStatus.CREATED);
    }

    @PostMapping("/complet")
    @Operation(summary = "CrÃ©er un jourSemaine (FullDTO)")
    public ResponseEntity<JourSemaineFullDTO> creerComplet(@RequestBody JourSemaineFullDTO fullDTO) {
        return new ResponseEntity<>(service.creerComplet(fullDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtenir un jourSemaine par identifiant (FullDTO)")
    public ResponseEntity<JourSemaineFullDTO> obtenirParId(@PathVariable @Parameter(description = "Identifiant") Long id) {
        return ResponseEntity.ok(service.obtenirParId(id));
    }

    @GetMapping("/{id}/basic")
    @Operation(summary = "Obtenir un jourSemaine par identifiant (BasicDTO)")
    public ResponseEntity<JourSemaineBasicDTO> obtenirBasicParId(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenirBasicParId(id));
    }

    @GetMapping
    @Operation(summary = "Lister tous les jourSemaine (FullDTO)")
    public ResponseEntity<List<JourSemaineFullDTO>> obtenirTous() {
        return ResponseEntity.ok(service.obtenirTous());
    }

    @GetMapping("/basic")
    @Operation(summary = "Lister tous les jourSemaine (BasicDTO)")
    public ResponseEntity<List<JourSemaineBasicDTO>> obtenirTousBasic() {
        return ResponseEntity.ok(service.obtenirTousBasic());
    }

    @GetMapping("/page")
    @Operation(summary = "Lister tous les jourSemaine (paginÃ©)")
    public ResponseEntity<Page<JourSemaineFullDTO>> obtenirTous(Pageable pageable) {
        return ResponseEntity.ok(service.obtenirTous(pageable));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier un jourSemaine (FullDTO)")
    public ResponseEntity<JourSemaineFullDTO> modifier(@PathVariable Long id, @RequestBody JourSemaineFullDTO fullDTO) {
        return ResponseEntity.ok(service.modifier(id, fullDTO));
    }

    @PutMapping("/{id}/basic")
    @Operation(summary = "Modifier un jourSemaine (BasicDTO)")
    public ResponseEntity<JourSemaineBasicDTO> modifierBasic(@PathVariable Long id, @RequestBody JourSemaineBasicDTO basicDTO) {
        return ResponseEntity.ok(service.modifierBasic(id, basicDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un jourSemaine")
    public ResponseEntity<Void> supprimer(@PathVariable Long id) {
        service.supprimer(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/existe")
    @Operation(summary = "VÃ©rifier l'existence d'un jourSemaine")
    public ResponseEntity<Boolean> existe(@PathVariable Long id) {
        return ResponseEntity.ok(service.existe(id));
    }

    @GetMapping("/compter")
    @Operation(summary = "Compter les jourSemaine")
    public ResponseEntity<Long> compter() {
        return ResponseEntity.ok(service.compter());
    }
}
