package com.micatek.flowers.application.exceptions;

import com.micatek.flowers.application.codes.ErrorKeys;
import com.micatek.flowers.application.codes.ErrorMessages;

public class RequiredSuperAdminPermissionException extends AuthorizeException {
    public RequiredSuperAdminPermissionException() {
        super(ErrorKeys.REQUIRE_SUPER_ADMIN.getCode(), ErrorMessages.REQUIRE_SUPER_ADMIN.getMessage());
    }
}
