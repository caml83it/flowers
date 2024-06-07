package com.micatek.flowers.distributed.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RefreshRequest {
    @JsonProperty("refresh_token")
    @NotNull
    private String refreshToken;
}
