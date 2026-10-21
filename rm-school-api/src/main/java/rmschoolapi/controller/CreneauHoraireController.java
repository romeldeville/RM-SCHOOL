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
import rmschoolapi.dto.basic.CreneauHoraireBasicDTO;
import rmschoolapi.dto.full.CreneauHoraireFullDTO;
import rmschoolapi.service.CreneauHoraireService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/creneau-horaire")
@Tag(name = "CreneauHoraire", description = "Gestion des creneauHoraire")
public class CreneauHoraireController {

    private final CreneauHoraireService service;

    @PostMapping
    @Operation(summary = "CrÃ©er un creneauHoraire (BasicDTO)")
    public ResponseEntity<CreneauHoraireBasicDTO> creer(@RequestBody CreneauHoraireBasicDTO basicDTO) {
        return new ResponseEntity<>(service.creer(basicDTO), HttpStatus.CREATED);
    }

    @PostMapping("/complet")
    @Operation(summary = "CrÃ©er un creneauHoraire (FullDTO)")
    public ResponseEntity<CreneauHoraireFullDTO> creerComplet(@RequestBody CreneauHoraireFullDTO fullDTO) {
        return new ResponseEntity<>(service.creerComplet(fullDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtenir un creneauHoraire par identifiant (FullDTO)")
    public ResponseEntity<CreneauHoraireFullDTO> obtenirParId(@PathVariable @Parameter(description = "Identifiant") Long id) {
        return ResponseEntity.ok(service.obtenirParId(id));
    }

    @GetMapping("/{id}/basic")
    @Operation(summary = "Obtenir un creneauHoraire par identifiant (BasicDTO)")
    public ResponseEntity<CreneauHoraireBasicDTO> obtenirBasicParId(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenirBasicParId(id));
    }

    @GetMapping
    @Operation(summary = "Lister tous les creneauHoraire (FullDTO)")
    public ResponseEntity<List<CreneauHoraireFullDTO>> obtenirTous() {
        return ResponseEntity.ok(service.obtenirTous());
    }

    @GetMapping("/basic")
    @Operation(summary = "Lister tous les creneauHoraire (BasicDTO)")
    public ResponseEntity<List<CreneauHoraireBasicDTO>> obtenirTousBasic() {
        return ResponseEntity.ok(service.obtenirTousBasic());
    }

    @GetMapping("/page")
    @Operation(summary = "Lister tous les creneauHoraire (paginÃ©)")
    public ResponseEntity<Page<CreneauHoraireFullDTO>> obtenirTous(Pageable pageable) {
        return ResponseEntity.ok(service.obtenirTous(pageable));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier un creneauHoraire (FullDTO)")
    public ResponseEntity<CreneauHoraireFullDTO> modifier(@PathVariable Long id, @RequestBody CreneauHoraireFullDTO fullDTO) {
        return ResponseEntity.ok(service.modifier(id, fullDTO));
    }

    @PutMapping("/{id}/basic")
    @Operation(summary = "Modifier un creneauHoraire (BasicDTO)")
    public ResponseEntity<CreneauHoraireBasicDTO> modifierBasic(@PathVariable Long id, @RequestBody CreneauHoraireBasicDTO basicDTO) {
        return ResponseEntity.ok(service.modifierBasic(id, basicDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un creneauHoraire")
    public ResponseEntity<Void> supprimer(@PathVariable Long id) {
        service.supprimer(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/existe")
    @Operation(summary = "VÃ©rifier l'existence d'un creneauHoraire")
    public ResponseEntity<Boolean> existe(@PathVariable Long id) {
        return ResponseEntity.ok(service.existe(id));
    }

    @GetMapping("/compter")
    @Operation(summary = "Compter les creneauHoraire")
    public ResponseEntity<Long> compter() {
        return ResponseEntity.ok(service.compter());
    }
}
