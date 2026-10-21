package rmschoolapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rmschoolapi.dto.auth.JwtResponse;
import rmschoolapi.dto.auth.LoginRequest;
import rmschoolapi.dto.auth.RegisterRequest;
import rmschoolapi.service.AuthService;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Tag(name = "Authentification", description = "Connexion et inscription avec JWT")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/connexion")
    @Operation(summary = "Connexion avec login et mot de passe")
    public ResponseEntity<JwtResponse> connexion(@Valid @RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(authService.connexion(loginRequest));
    }

    @PostMapping("/inscription")
    @Operation(summary = "Inscription d'un nouveau compte utilisateur")
    public ResponseEntity<?> inscription(@Valid @RequestBody RegisterRequest registerRequest) {
        authService.inscription(registerRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body("Compte utilisateur créé avec succès");
    }
}
