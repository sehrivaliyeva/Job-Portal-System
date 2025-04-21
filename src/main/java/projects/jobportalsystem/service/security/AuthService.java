package projects.jobportalsystem.service.security;

import projects.jobportalsystem.dto.security.AuthResponse;
import projects.jobportalsystem.dto.security.LoginDTO;
import projects.jobportalsystem.dto.security.RegisterDTO;

public interface AuthService {
    AuthResponse register(RegisterDTO request);
    AuthResponse login(LoginDTO request);


}
