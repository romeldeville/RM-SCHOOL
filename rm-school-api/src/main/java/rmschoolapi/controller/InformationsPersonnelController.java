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
import rmschoolapi.dto.basic.InformationsPersonnelBasicDTO;
import rmschoolapi.dto.full.InformationsPersonnelFullDTO;
import rmschoolapi.service.InformationsPersonnelService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/informations-personnel")
@Tag(name = "InformationsPersonnel", description = "Gestion des informationsPersonnel")
public class InformationsPersonnelController {

    private final InformationsPersonnelService service;

    @PostMapping
    @Operation(summary = "CrÃ©er un informationsPersonnel (BasicDTO)")
    public ResponseEntity<InformationsPersonnelBasicDTO> creer(@RequestBody InformationsPersonnelBasicDTO basicDTO) {
        return new ResponseEntity<>(service.creer(basicDTO), HttpStatus.CREATED);
    }

    @PostMapping("/complet")
    @Operation(summary = "CrÃ©er un informationsPersonnel (FullDTO)")
    public ResponseEntity<InformationsPersonnelFullDTO> creerComplet(@RequestBody InformationsPersonnelFullDTO fullDTO) {
        return new ResponseEntity<>(service.creerComplet(fullDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtenir un informationsPersonnel par identifiant (FullDTO)")
    public ResponseEntity<InformationsPersonnelFullDTO> obtenirParId(@PathVariable @Parameter(description = "Identifiant") Long id) {
        return ResponseEntity.ok(service.obtenirParId(id));
    }

    @GetMapping("/{id}/basic")
    @Operation(summary = "Obtenir un informationsPersonnel par identifiant (BasicDTO)")
    public ResponseEntity<InformationsPersonnelBasicDTO> obtenirBasicParId(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenirBasicParId(id));
    }

    @GetMapping
    @Operation(summary = "Lister tous les informationsPersonnel (FullDTO)")
    public ResponseEntity<List<InformationsPersonnelFullDTO>> obtenirTous() {
        return ResponseEntity.ok(service.obtenirTous());
    }

    @GetMapping("/basic")
    @Operation(summary = "Lister tous les informationsPersonnel (BasicDTO)")
    public ResponseEntity<List<InformationsPersonnelBasicDTO>> obtenirTousBasic() {
        return ResponseEntity.ok(service.obtenirTousBasic());
    }

    @GetMapping("/page")
    @Operation(summary = "Lister tous les informationsPersonnel (paginÃ©)")
    public ResponseEntity<Page<InformationsPersonnelFullDTO>> obtenirTous(Pageable pageable) {
        return ResponseEntity.ok(service.obtenirTous(pageable));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier un informationsPersonnel (FullDTO)")
    public ResponseEntity<InformationsPersonnelFullDTO> modifier(@PathVariable Long id, @RequestBody InformationsPersonnelFullDTO fullDTO) {
        return ResponseEntity.ok(service.modifier(id, fullDTO));
    }

    @PutMapping("/{id}/basic")
    @Operation(summary = "Modifier un informationsPersonnel (BasicDTO)")
    public ResponseEntity<InformationsPersonnelBasicDTO> modifierBasic(@PathVariable Long id, @RequestBody InformationsPersonnelBasicDTO basicDTO) {
        return ResponseEntity.ok(service.modifierBasic(id, basicDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un informationsPersonnel")
    public ResponseEntity<Void> supprimer(@PathVariable Long id) {
        service.supprimer(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/existe")
    @Operation(summary = "VÃ©rifier l'existence d'un informationsPersonnel")
    public ResponseEntity<Boolean> existe(@PathVariable Long id) {
        return ResponseEntity.ok(service.existe(id));
    }

    @GetMapping("/compter")
    @Operation(summary = "Compter les informationsPersonnel")
    public ResponseEntity<Long> compter() {
        return ResponseEntity.ok(service.compter());
    }
}
