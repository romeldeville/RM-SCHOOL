package rmschoolapi.service;

import rmschoolapi.dto.auth.JwtResponse;
import rmschoolapi.dto.auth.LoginRequest;
import rmschoolapi.dto.auth.RegisterRequest;
import rmschoolapi.entity.CompteUtilisateur;

public interface AuthService {

    JwtResponse connexion(LoginRequest loginRequest);

    CompteUtilisateur inscription(RegisterRequest registerRequest);
}
