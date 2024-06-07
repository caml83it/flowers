package com.micatek.flowers.application.exceptions;

import com.micatek.flowers.application.codes.ErrorKeys;
import com.micatek.flowers.application.codes.ErrorMessages;

public class UserNotFoundException extends NotFoundException {
    public UserNotFoundException() {
        super(ErrorKeys.USER_NOT_FOUND.getCode(), ErrorMessages.USER_NOT_FOUND.getMessage());
    }
}
