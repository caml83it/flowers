package com.micatek.flowers.distributed.responses;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.micatek.flowers.domain.entities.Auth;
import com.micatek.flowers.domain.entities.User;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse extends BaseResponse {
    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("refresh_token")
    private String refreshToken;
    @JsonProperty("user")
    private User user;
}
