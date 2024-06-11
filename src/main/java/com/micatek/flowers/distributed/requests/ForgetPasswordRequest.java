package com.micatek.flowers.distributed.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ForgetPasswordRequest {
    @JsonProperty("email")
    @NotNull
    @Email
    private String email;
}
