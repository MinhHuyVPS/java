package security.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class UserUpdateRequest {
    private String password;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private LocalDate birthday;
}
