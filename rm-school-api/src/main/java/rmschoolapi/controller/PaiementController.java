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
import rmschoolapi.dto.basic.PaiementBasicDTO;
import rmschoolapi.dto.full.PaiementFullDTO;
import rmschoolapi.service.PaiementService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/paiement")
@Tag(name = "Paiement", description = "Gestion des paiement")
public class PaiementController {

    private final PaiementService service;

    @PostMapping
    @Operation(summary = "CrÃ©er un paiement (BasicDTO)")
    public ResponseEntity<PaiementBasicDTO> creer(@RequestBody PaiementBasicDTO basicDTO) {
        return new ResponseEntity<>(service.creer(basicDTO), HttpStatus.CREATED);
    }

    @PostMapping("/complet")
    @Operation(summary = "CrÃ©er un paiement (FullDTO)")
    public ResponseEntity<PaiementFullDTO> creerComplet(@RequestBody PaiementFullDTO fullDTO) {
        return new ResponseEntity<>(service.creerComplet(fullDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtenir un paiement par identifiant (FullDTO)")
    public ResponseEntity<PaiementFullDTO> obtenirParId(@PathVariable @Parameter(description = "Identifiant") Long id) {
        return ResponseEntity.ok(service.obtenirParId(id));
    }

    @GetMapping("/{id}/basic")
    @Operation(summary = "Obtenir un paiement par identifiant (BasicDTO)")
    public ResponseEntity<PaiementBasicDTO> obtenirBasicParId(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenirBasicParId(id));
    }

    @GetMapping
    @Operation(summary = "Lister tous les paiement (FullDTO)")
    public ResponseEntity<List<PaiementFullDTO>> obtenirTous() {
        return ResponseEntity.ok(service.obtenirTous());
    }

    @GetMapping("/basic")
    @Operation(summary = "Lister tous les paiement (BasicDTO)")
    public ResponseEntity<List<PaiementBasicDTO>> obtenirTousBasic() {
        return ResponseEntity.ok(service.obtenirTousBasic());
    }

    @GetMapping("/page")
    @Operation(summary = "Lister tous les paiement (paginÃ©)")
    public ResponseEntity<Page<PaiementFullDTO>> obtenirTous(Pageable pageable) {
        return ResponseEntity.ok(service.obtenirTous(pageable));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier un paiement (FullDTO)")
    public ResponseEntity<PaiementFullDTO> modifier(@PathVariable Long id, @RequestBody PaiementFullDTO fullDTO) {
        return ResponseEntity.ok(service.modifier(id, fullDTO));
    }

    @PutMapping("/{id}/basic")
    @Operation(summary = "Modifier un paiement (BasicDTO)")
    public ResponseEntity<PaiementBasicDTO> modifierBasic(@PathVariable Long id, @RequestBody PaiementBasicDTO basicDTO) {
        return ResponseEntity.ok(service.modifierBasic(id, basicDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un paiement")
    public ResponseEntity<Void> supprimer(@PathVariable Long id) {
        service.supprimer(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/existe")
    @Operation(summary = "VÃ©rifier l'existence d'un paiement")
    public ResponseEntity<Boolean> existe(@PathVariable Long id) {
        return ResponseEntity.ok(service.existe(id));
    }

    @GetMapping("/compter")
    @Operation(summary = "Compter les paiement")
    public ResponseEntity<Long> compter() {
        return ResponseEntity.ok(service.compter());
    }
}
