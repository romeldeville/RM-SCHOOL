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
import rmschoolapi.dto.basic.PersonnelBasicDTO;
import rmschoolapi.dto.full.PersonnelFullDTO;
import rmschoolapi.service.PersonnelService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/personnel")
@Tag(name = "Personnel", description = "Gestion des personnel")
public class PersonnelController {

    private final PersonnelService service;

    @PostMapping
    @Operation(summary = "CrÃ©er un personnel (BasicDTO)")
    public ResponseEntity<PersonnelBasicDTO> creer(@RequestBody PersonnelBasicDTO basicDTO) {
        return new ResponseEntity<>(service.creer(basicDTO), HttpStatus.CREATED);
    }

    @PostMapping("/complet")
    @Operation(summary = "CrÃ©er un personnel (FullDTO)")
    public ResponseEntity<PersonnelFullDTO> creerComplet(@RequestBody PersonnelFullDTO fullDTO) {
        return new ResponseEntity<>(service.creerComplet(fullDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtenir un personnel par identifiant (FullDTO)")
    public ResponseEntity<PersonnelFullDTO> obtenirParId(@PathVariable @Parameter(description = "Identifiant") Long id) {
        return ResponseEntity.ok(service.obtenirParId(id));
    }

    @GetMapping("/{id}/basic")
    @Operation(summary = "Obtenir un personnel par identifiant (BasicDTO)")
    public ResponseEntity<PersonnelBasicDTO> obtenirBasicParId(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenirBasicParId(id));
    }

    @GetMapping
    @Operation(summary = "Lister tous les personnel (FullDTO)")
    public ResponseEntity<List<PersonnelFullDTO>> obtenirTous() {
        return ResponseEntity.ok(service.obtenirTous());
    }

    @GetMapping("/basic")
    @Operation(summary = "Lister tous les personnel (BasicDTO)")
    public ResponseEntity<List<PersonnelBasicDTO>> obtenirTousBasic() {
        return ResponseEntity.ok(service.obtenirTousBasic());
    }

    @GetMapping("/page")
    @Operation(summary = "Lister tous les personnel (paginÃ©)")
    public ResponseEntity<Page<PersonnelFullDTO>> obtenirTous(Pageable pageable) {
        return ResponseEntity.ok(service.obtenirTous(pageable));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier un personnel (FullDTO)")
    public ResponseEntity<PersonnelFullDTO> modifier(@PathVariable Long id, @RequestBody PersonnelFullDTO fullDTO) {
        return ResponseEntity.ok(service.modifier(id, fullDTO));
    }

    @PutMapping("/{id}/basic")
    @Operation(summary = "Modifier un personnel (BasicDTO)")
    public ResponseEntity<PersonnelBasicDTO> modifierBasic(@PathVariable Long id, @RequestBody PersonnelBasicDTO basicDTO) {
        return ResponseEntity.ok(service.modifierBasic(id, basicDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un personnel")
    public ResponseEntity<Void> supprimer(@PathVariable Long id) {
        service.supprimer(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/existe")
    @Operation(summary = "VÃ©rifier l'existence d'un personnel")
    public ResponseEntity<Boolean> existe(@PathVariable Long id) {
        return ResponseEntity.ok(service.existe(id));
    }

    @GetMapping("/compter")
    @Operation(summary = "Compter les personnel")
    public ResponseEntity<Long> compter() {
        return ResponseEntity.ok(service.compter());
    }
}
