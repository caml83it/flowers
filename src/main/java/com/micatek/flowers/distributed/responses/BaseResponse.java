package com.micatek.flowers.distributed.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse {
    /**
     * Value of result contains [ok, error]
     */
    @JsonProperty(value = "result", required = true)
    private String result;
    @JsonProperty(value = "code", required = true)
    private String code;
    @JsonProperty(value = "message", required = false)
    private String message;
}
