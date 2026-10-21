package rmschoolapi.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rmschoolapi.repository.CompteUtilisateurRepository;

@Service
@RequiredArgsConstructor
public class UtilisateurDetailsService implements UserDetailsService {

    private final CompteUtilisateurRepository compteUtilisateurRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return compteUtilisateurRepository.findByLogin(login)
                .map(UtilisateurDetails::construire)
                .orElseThrow(() -> new UsernameNotFoundException("Compte utilisateur introuvable pour le login : " + login));
    }
}
