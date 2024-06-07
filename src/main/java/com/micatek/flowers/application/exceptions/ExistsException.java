package com.micatek.flowers.application.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ExistsException extends RuntimeException {
    private String code;
    private String message;
}
