package security.dto.request;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserCreationRequest {
    private String username;
    @Size(min = 8, message = "Password must be at least a characters")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).*$", message = "Password must contain at least one uppercase letter and one special character")
    private String password;
    private String email;
    private String firstname;
    private String lastname;
    private String phone;
    private LocalDate birthday;

}
