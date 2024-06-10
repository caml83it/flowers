package com.micatek.flowers.application.codes;

import lombok.Getter;

@Getter
public enum ErrorKeys {
    // AUTH: 101
    AUTH_NOT_FOUND("101-404-100"),
    AUTH_EXISTS("101-400-999"),
    // AUTHORIZE
    REQUIRE_ADMIN("999-401-001"),
    REQUIRE_SUPER_ADMIN("999-401-999"),
    REQUIRE_AUTHORIZE("999-401-000"),
    // PRODUCT: 301
    PRODUCT_NOT_FOUND("301-404-100"),

    // USER: 201
    USER_NOT_FOUND("201-404-100");


    private final String code;
    ErrorKeys(String code) {
        this.code = code;
    }
}

