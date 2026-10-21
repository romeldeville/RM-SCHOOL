package rmschoolapi.dto.auth;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record RegisterRequest(
        @NotBlank(message = "Le login est requis")
        @Size(min = 3, max = 50)
        String login,

        @NotBlank(message = "Le mot de passe est requis")
        @Size(min = 8, max = 100)
        String motPasse,

        @NotNull(message = "L'identifiant du rôle est requis")
        Long roleId,

        @NotNull(message = "L'identifiant du statut est requis")
        Long statutCompteUtilisateurId
) {
}
