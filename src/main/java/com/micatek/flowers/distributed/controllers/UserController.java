package com.micatek.flowers.distributed.controllers;

import com.micatek.flowers.application.services.UserService;
import com.micatek.flowers.common.annotations.IsAdmin;
import com.micatek.flowers.domain.entities.Auth;
import com.micatek.flowers.domain.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {
    private final UserService userService;

    @GetMapping(value = "/me")
    public ResponseEntity<User> getProfile() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Auth auth = (Auth) authentication.getPrincipal();
        return ResponseEntity.ok(auth.getUser());
    }

    @IsAdmin
    @GetMapping("/employees")
    public ResponseEntity<List<User>> getEmployees() {
        List<User> employees = userService.getEmployees();
        return ResponseEntity.ok(employees);
    }
}
