package com.micatek.flowers.common.annotations;

import com.micatek.flowers.domain.enums.UserRole;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;

public class UserRoleValidator implements ConstraintValidator<ValidUserRole, UserRole> {

    @Override
    public void initialize(ValidUserRole constraintAnnotation) {
    }

    @Override
    public boolean isValid(UserRole value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        return Arrays.asList(UserRole.values()).contains(value);
    }
}