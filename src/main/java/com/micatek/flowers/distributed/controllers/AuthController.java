package com.micatek.flowers.distributed.controllers;

import com.micatek.flowers.application.services.AuthService;
import com.micatek.flowers.application.services.EmailService;
import com.micatek.flowers.distributed.requests.ForgetPasswordRequest;
import com.micatek.flowers.distributed.requests.LoginRequest;
import com.micatek.flowers.distributed.requests.RegistrationRequest;
import com.micatek.flowers.distributed.responses.AuthResponse;
import com.micatek.flowers.distributed.responses.BaseResponse;
import com.micatek.flowers.distributed.responses.RegistrationResponse;
import com.micatek.flowers.utils.Codes;
import com.micatek.flowers.utils.Constants;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AuthController {
    private final AuthService authService;
    private final EmailService emailService;

    @PostMapping("/registers")
    public ResponseEntity<RegistrationResponse> registration(
        @RequestBody @Valid RegistrationRequest request
    ) {
        RegistrationResponse response = authService.register(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(
        @RequestBody @Valid LoginRequest request
    ) throws Exception {
        AuthResponse response = authService.login(request.getEmail(), request.getPassword());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/forget-password")
    public ResponseEntity<BaseResponse> forgetPassword(
            @RequestBody @Valid ForgetPasswordRequest request
    ) {
        emailService.sendEmail(request.getEmail(), "Forgot Password", "");
        BaseResponse response = new BaseResponse(Constants.OK, Codes.SUCCESS, null);
        return ResponseEntity.ok(response);
    }
}
