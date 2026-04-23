package org.shopsphere.shopsphere.dto;

import lombok.Data;
import jakarta.validation.constraints.*;

@Data
public class RegisterRequest {

    @NotBlank(message = "Name required")
    private String name;

    @Email(message = "Valid email required")
    @NotBlank(message = "Email required")
    private String email;

    @NotBlank(message = "Password required")
    @Size(min = 6, message = "Min 6 characters")
    private String password;

}