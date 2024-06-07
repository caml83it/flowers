package com.micatek.flowers.distributed.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginRequest {
    @JsonProperty("email")
    @NotNull
    @Email
    private String email;

    @JsonProperty("password")
    @NotNull
    @Min(value = 8, message = "Password must be greater than 8 characters")
    private String password;
}
