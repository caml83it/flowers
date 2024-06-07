package com.micatek.flowers.distributed.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.micatek.flowers.common.annotations.ValidUserRole;
import com.micatek.flowers.domain.enums.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegistrationRequest {
    @JsonProperty("name")
    @NotNull
    private String name;

    @JsonProperty("email")
    @NotNull
    @Email
    private String email;

    @JsonProperty("password")
    @NotNull
    @Min(value = 8, message = "Password must be greater than 8 characters")
    private String password;

    @JsonProperty("role")
    @ValidUserRole(message = "Role should be valid")
    private UserRole role;
}
