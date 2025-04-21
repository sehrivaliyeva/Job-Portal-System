package projects.jobportalsystem.dto.security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {
    private String response;
    ///sistemde register olduqdan sonra response bize bu class vasitesile qayidacag

}