package org.shopsphere.shopsphere.dto;

import lombok.Data;
import jakarta.validation.constraints.*;

@Data
public class LoginRequest {

    @Email(message = "Valid email required")
    @NotBlank(message = "Email required")
    private String email;

    @NotBlank(message = "Password required")
    private String password;

}
