package rmschoolapi.dto.auth;

import java.util.List;

public record JwtResponse(
        String token,
        String type,
        Long id,
        String login,
        String role,
        List<String> privileges
) {
    public JwtResponse(String token, Long id, String login, String role, List<String> privileges) {
        this(token, "Bearer", id, login, role, privileges);
    }
}
