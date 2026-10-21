package rmschoolapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rmschoolapi.dto.auth.JwtResponse;
import rmschoolapi.dto.auth.LoginRequest;
import rmschoolapi.dto.auth.RegisterRequest;
import rmschoolapi.entity.CompteUtilisateur;
import rmschoolapi.exception.ConflitRessourceException;
import rmschoolapi.exception.RessourceIntrouvableException;
import rmschoolapi.repository.CompteUtilisateurRepository;
import rmschoolapi.repository.RoleRepository;
import rmschoolapi.repository.StatutCompteUtilisateurRepository;
import rmschoolapi.security.JwtService;
import rmschoolapi.security.UtilisateurDetails;
import rmschoolapi.service.AuthService;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final CompteUtilisateurRepository compteUtilisateurRepository;
    private final RoleRepository roleRepository;
    private final StatutCompteUtilisateurRepository statutCompteUtilisateurRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public JwtResponse connexion(LoginRequest loginRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.login(), loginRequest.motPasse()));
            UtilisateurDetails utilisateurDetails = (UtilisateurDetails) authentication.getPrincipal();
            String token = jwtService.genererToken(utilisateurDetails);
            return new JwtResponse(token, utilisateurDetails.getId(), utilisateurDetails.getUsername(),
                    utilisateurDetails.getRoleNom(), utilisateurDetails.getPrivilegesNoms());
        } catch (Exception ex) {
            throw new BadCredentialsException("Login ou mot de passe incorrect");
        }
    }

    @Override
    public CompteUtilisateur inscription(RegisterRequest registerRequest) {
        if (compteUtilisateurRepository.existsByLogin(registerRequest.login())) {
            throw ConflitRessourceException.doublon("login", registerRequest.login());
        }
        CompteUtilisateur compteUtilisateur = new CompteUtilisateur();
        compteUtilisateur.setLogin(registerRequest.login());
        compteUtilisateur.setMotPasse(passwordEncoder.encode(registerRequest.motPasse()));
        compteUtilisateur.setRole(roleRepository.findById(registerRequest.roleId())
                .orElseThrow(() -> new RessourceIntrouvableException("Role", registerRequest.roleId())));
        compteUtilisateur.setStatutCompteUtilisateur(statutCompteUtilisateurRepository.findById(registerRequest.statutCompteUtilisateurId())
                .orElseThrow(() -> new RessourceIntrouvableException("StatutCompteUtilisateur", registerRequest.statutCompteUtilisateurId())));
        return compteUtilisateurRepository.save(compteUtilisateur);
    }
}
