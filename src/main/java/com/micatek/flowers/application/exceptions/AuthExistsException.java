package com.micatek.flowers.application.exceptions;

import com.micatek.flowers.application.codes.ErrorKeys;
import com.micatek.flowers.application.codes.ErrorMessages;

public class AuthExistsException extends ExistsException {
    public AuthExistsException() {
        super(ErrorKeys.AUTH_EXISTS.getCode(), ErrorMessages.AUTH_EXISTS.getMessage());
    }
}
