package com.micatek.flowers.application.exceptions;

import com.micatek.flowers.application.codes.ErrorKeys;
import com.micatek.flowers.application.codes.ErrorMessages;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class NotFoundException extends RuntimeException {
    private String code;
    private String message;
}


