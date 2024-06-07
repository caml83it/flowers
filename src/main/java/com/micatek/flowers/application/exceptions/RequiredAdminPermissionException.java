package com.micatek.flowers.application.exceptions;

import com.micatek.flowers.application.codes.ErrorKeys;
import com.micatek.flowers.application.codes.ErrorMessages;

public class RequiredAdminPermissionException extends AuthorizeException {
    public RequiredAdminPermissionException() {
        super(ErrorKeys.REQUIRE_ADMIN.getCode(), ErrorMessages.REQUIRE_ADMIN.getMessage());
    }
}

