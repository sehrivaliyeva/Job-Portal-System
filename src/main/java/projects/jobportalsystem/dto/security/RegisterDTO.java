package projects.jobportalsystem.dto.security;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class RegisterDTO {
    @NotBlank(message = "First name must not be blank")
    private String username;
    @NotBlank(message = "Password must not be blank")
    private String password;

    /// sayta register olarken bu classdan istifade edecik
}