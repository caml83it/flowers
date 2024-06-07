package com.micatek.flowers.distributed.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class ErrorResponse {
    @JsonProperty("message")
    private final String message;
    @JsonProperty("code")
    private final String code;
    @JsonProperty("result")
    private final String result = "nok";
    @JsonProperty("timestamp")
    private final LocalDateTime timestamp;

    public ErrorResponse(String message, String code, LocalDateTime time) {
        this.message = message;
        this.code = code;
        this.timestamp = time;
    }
}
