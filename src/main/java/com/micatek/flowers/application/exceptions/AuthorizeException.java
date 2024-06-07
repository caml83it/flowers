package com.micatek.flowers.application.exceptions;

import com.micatek.flowers.application.codes.ErrorKeys;
import com.micatek.flowers.application.codes.ErrorMessages;

public class AuthorizeException extends BaseException {
    public AuthorizeException(String code, String message) {
        super(code, message);
    }
}

