package rmschoolapi.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtService {

    @Value("${app.jwt.secret}")
    private String secret;

    @Value("${app.jwt.expiration-ms}")
    private long expirationMs;

    @Value("${app.jwt.header}")
    private String header;

    @Value("${app.jwt.prefix}")
    private String prefix;

    public String genererToken(UtilisateurDetails utilisateurDetails) {
        Date maintenant = new Date();
        Date expiration = new Date(maintenant.getTime() + expirationMs);
        return Jwts.builder()
                .subject(utilisateurDetails.getUsername())
                .claim("id", utilisateurDetails.getId())
                .claim("role", utilisateurDetails.getRoleNom())
                .claim("privileges", utilisateurDetails.getPrivilegesNoms())
                .issuedAt(maintenant)
                .expiration(expiration)
                .signWith(cleSecrete())
                .compact();
    }

    public String extraireLogin(String token) {
        return extraireClaims(token).getSubject();
    }

    public boolean validerToken(String token, UtilisateurDetails utilisateurDetails) {
        String login = extraireLogin(token);
        return login.equals(utilisateurDetails.getUsername()) && !estExpire(token);
    }

    public String extraireToken(HttpServletRequest request) {
        String bearer = request.getHeader(header);
        if (StringUtils.hasText(bearer) && bearer.startsWith(prefix)) {
            return bearer.substring(prefix.length());
        }
        return null;
    }

    private boolean estExpire(String token) {
        return extraireClaims(token).getExpiration().before(new Date());
    }

    private Claims extraireClaims(String token) {
        return Jwts.parser()
                .verifyWith(cleSecrete())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    private SecretKey cleSecrete() {
        byte[] keyBytes = Decoders.BASE64.decode(java.util.Base64.getEncoder().encodeToString(secret.getBytes()));
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
