package com.micatek.flowers.common.annotations;


import com.micatek.flowers.application.exceptions.RequiredAdminPermissionException;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RoleCheckerAspect {
//    @Before("@annotation(com.example.security.IsUser)")
//    public void checkUserRole() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication == null || authentication.getAuthorities().stream()
//                .map(GrantedAuthority::getAuthority)
//                .noneMatch(role -> role.equals("ROLE_USER"))) {
//            throw new SecurityException("User role required");
//        }
//    }

    @Before("@annotation(com.micatek.flowers.common.annotations.IsAdmin)")
    public void checkAdminRole() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .noneMatch(role -> role.equals("ROLE_ADMIN"))) {
            throw new RequiredAdminPermissionException();
        }
    }
}
