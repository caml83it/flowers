package com.micatek.flowers.application.exceptions;

import com.micatek.flowers.application.codes.ErrorKeys;
import com.micatek.flowers.application.codes.ErrorMessages;

public class ProductNotFoundException extends NotFoundException {
    public ProductNotFoundException() {
        super(ErrorKeys.PRODUCT_NOT_FOUND.getCode(), ErrorMessages.PRODUCT_NOT_FOUND.getMessage());
    }
}
