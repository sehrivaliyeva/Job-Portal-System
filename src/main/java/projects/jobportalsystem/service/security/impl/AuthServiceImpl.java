package projects.jobportalsystem.service.security.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projects.jobportalsystem.dto.security.AuthResponse;
import projects.jobportalsystem.dto.security.LoginDTO;
import projects.jobportalsystem.dto.security.RegisterDTO;
import projects.jobportalsystem.entity.User;
import projects.jobportalsystem.enums.Role;
import projects.jobportalsystem.service.security.AuthService;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final projects.jobportalsystem.repo.UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtServiceImpl jwtService;
    private final AuthenticationManager authenticationManager;

    /// herbir register olan usere biz ozumuz default olaraq rolunu USER teyin edirik
    @Override
    public AuthResponse register(RegisterDTO request) {
        User user = new User();
        user.setRole(Role.USER);
        user.setPassword(request.getPassword());
        user.setUsername(request.getUsername());
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        userRepository.save(user);
        return new AuthResponse("User register successfully !!");
    }

    @Override
    public AuthResponse login(LoginDTO request) {
        try {
            Authentication authenticate = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(),
                            request.getPassword()
                    )
            );
        } catch (Exception e) {
            throw new RuntimeException(
                    "Invalid username or password. Please check your credentials and try again.");
        }

       User user = userRepository.findByUsername(request.getUsername()).orElseThrow(
                () -> new RuntimeException("Invalid username or password"));

        String accessToken = jwtService.generateToken(user);

        return new AuthResponse(accessToken);
    }


}