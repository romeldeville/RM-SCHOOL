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
import rmschoolapi.dto.basic.AnneeScolaireCouranteBasicDTO;
import rmschoolapi.dto.full.AnneeScolaireCouranteFullDTO;
import rmschoolapi.service.AnneeScolaireCouranteService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/annee-scolaire-courante")
@Tag(name = "AnneeScolaireCourante", description = "Gestion des anneeScolaireCourante")
public class AnneeScolaireCouranteController {

    private final AnneeScolaireCouranteService service;

    @PostMapping
    @Operation(summary = "CrÃ©er un anneeScolaireCourante (BasicDTO)")
    public ResponseEntity<AnneeScolaireCouranteBasicDTO> creer(@RequestBody AnneeScolaireCouranteBasicDTO basicDTO) {
        return new ResponseEntity<>(service.creer(basicDTO), HttpStatus.CREATED);
    }

    @PostMapping("/complet")
    @Operation(summary = "CrÃ©er un anneeScolaireCourante (FullDTO)")
    public ResponseEntity<AnneeScolaireCouranteFullDTO> creerComplet(@RequestBody AnneeScolaireCouranteFullDTO fullDTO) {
        return new ResponseEntity<>(service.creerComplet(fullDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtenir un anneeScolaireCourante par identifiant (FullDTO)")
    public ResponseEntity<AnneeScolaireCouranteFullDTO> obtenirParId(@PathVariable @Parameter(description = "Identifiant") Long id) {
        return ResponseEntity.ok(service.obtenirParId(id));
    }

    @GetMapping("/{id}/basic")
    @Operation(summary = "Obtenir un anneeScolaireCourante par identifiant (BasicDTO)")
    public ResponseEntity<AnneeScolaireCouranteBasicDTO> obtenirBasicParId(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenirBasicParId(id));
    }

    @GetMapping
    @Operation(summary = "Lister tous les anneeScolaireCourante (FullDTO)")
    public ResponseEntity<List<AnneeScolaireCouranteFullDTO>> obtenirTous() {
        return ResponseEntity.ok(service.obtenirTous());
    }

    @GetMapping("/basic")
    @Operation(summary = "Lister tous les anneeScolaireCourante (BasicDTO)")
    public ResponseEntity<List<AnneeScolaireCouranteBasicDTO>> obtenirTousBasic() {
        return ResponseEntity.ok(service.obtenirTousBasic());
    }

    @GetMapping("/page")
    @Operation(summary = "Lister tous les anneeScolaireCourante (paginÃ©)")
    public ResponseEntity<Page<AnneeScolaireCouranteFullDTO>> obtenirTous(Pageable pageable) {
        return ResponseEntity.ok(service.obtenirTous(pageable));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier un anneeScolaireCourante (FullDTO)")
    public ResponseEntity<AnneeScolaireCouranteFullDTO> modifier(@PathVariable Long id, @RequestBody AnneeScolaireCouranteFullDTO fullDTO) {
        return ResponseEntity.ok(service.modifier(id, fullDTO));
    }

    @PutMapping("/{id}/basic")
    @Operation(summary = "Modifier un anneeScolaireCourante (BasicDTO)")
    public ResponseEntity<AnneeScolaireCouranteBasicDTO> modifierBasic(@PathVariable Long id, @RequestBody AnneeScolaireCouranteBasicDTO basicDTO) {
        return ResponseEntity.ok(service.modifierBasic(id, basicDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un anneeScolaireCourante")
    public ResponseEntity<Void> supprimer(@PathVariable Long id) {
        service.supprimer(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/existe")
    @Operation(summary = "VÃ©rifier l'existence d'un anneeScolaireCourante")
    public ResponseEntity<Boolean> existe(@PathVariable Long id) {
        return ResponseEntity.ok(service.existe(id));
    }

    @GetMapping("/compter")
    @Operation(summary = "Compter les anneeScolaireCourante")
    public ResponseEntity<Long> compter() {
        return ResponseEntity.ok(service.compter());
    }
}
