package rmschoolapi.security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import rmschoolapi.entity.CompteUtilisateur;
import rmschoolapi.entity.Privilege;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public class UtilisateurDetails implements UserDetails {

    private Long id;
    private String login;
    private String motPasse;
    private String roleNom;
    private List<Privilege> privileges;
    private boolean actif;

    public static UtilisateurDetails construire(CompteUtilisateur compteUtilisateur) {
        List<Privilege> privileges = compteUtilisateur.getRole() != null
                ? compteUtilisateur.getRole().getPrivileges()
                : List.of();
        boolean actif = compteUtilisateur.getStatutCompteUtilisateur() == null
                || compteUtilisateur.getStatutCompteUtilisateur().getNom() == null
                || !"INACTIF".equalsIgnoreCase(compteUtilisateur.getStatutCompteUtilisateur().getNom())
                || "ACTIF".equalsIgnoreCase(compteUtilisateur.getStatutCompteUtilisateur().getNom());
        return new UtilisateurDetails(
                compteUtilisateur.getId(),
                compteUtilisateur.getLogin(),
                compteUtilisateur.getMotPasse(),
                compteUtilisateur.getRole() != null ? compteUtilisateur.getRole().getNom() : "USER",
                privileges,
                actif
        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = privileges.stream()
                .filter(p -> Boolean.TRUE.equals(p.getStatut()))
                .map(p -> new SimpleGrantedAuthority("PRIV_" + p.getNom()))
                .collect(Collectors.toList());
        if (roleNom != null) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + roleNom.toUpperCase()));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return motPasse;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return actif;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return actif;
    }

    public List<String> getPrivilegesNoms() {
        return privileges.stream()
                .filter(p -> Boolean.TRUE.equals(p.getStatut()))
                .map(Privilege::getNom)
                .toList();
    }
}
