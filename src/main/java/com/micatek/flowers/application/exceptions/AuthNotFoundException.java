package com.micatek.flowers.application.exceptions;

import com.micatek.flowers.application.codes.ErrorKeys;
import com.micatek.flowers.application.codes.ErrorMessages;

public class AuthNotFoundException extends NotFoundException {
    public AuthNotFoundException() {
        super(ErrorKeys.AUTH_NOT_FOUND.getCode(), ErrorMessages.AUTH_NOT_FOUND.getMessage());
    }
}
