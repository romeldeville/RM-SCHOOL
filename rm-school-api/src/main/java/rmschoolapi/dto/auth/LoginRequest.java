package rmschoolapi.dto.auth;

import jakarta.validation.constraints.NotBlank;

public record LoginRequest(
        @NotBlank(message = "Le login est requis")
        String login,

        @NotBlank(message = "Le mot de passe est requis")
        String motPasse
) {
}
