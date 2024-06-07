package com.micatek.flowers.application.exceptions;

import com.micatek.flowers.application.codes.ErrorKeys;
import com.micatek.flowers.application.codes.ErrorMessages;

public class RequiredAuthorizePermissionException extends AuthorizeException {
    public RequiredAuthorizePermissionException() {
        super(ErrorKeys.REQUIRE_AUTHORIZE.getCode(), ErrorMessages.REQUIRE_AUTHORIZE.getMessage());
    }
}
