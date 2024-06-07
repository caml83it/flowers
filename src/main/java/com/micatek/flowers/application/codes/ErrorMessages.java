package com.micatek.flowers.application.codes;

import lombok.Getter;

@Getter
public enum ErrorMessages {
    AUTH_NOT_FOUND("User Not Found"),
    AUTH_EXISTS("User Exists"),
    REQUIRE_ADMIN("Endpoint Must Be Request By Admin"),
    REQUIRE_SUPER_ADMIN("Endpoint Must Be Request By Super Admin"),
    REQUIRE_AUTHORIZE("Endpoint Must Be Authorize"),
    USER_NOT_FOUND("User Not Found");

    private final String message;
    ErrorMessages(String message) {
        this.message = message;
    }
}
