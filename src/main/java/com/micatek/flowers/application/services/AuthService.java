package com.micatek.flowers.application.services;

import com.micatek.flowers.application.exceptions.AuthExistsException;
import com.micatek.flowers.application.exceptions.AuthNotFoundException;
import com.micatek.flowers.application.exceptions.UserNotFoundException;
import com.micatek.flowers.distributed.requests.RegistrationRequest;
import com.micatek.flowers.distributed.responses.AuthResponse;
import com.micatek.flowers.distributed.responses.RegistrationResponse;
import com.micatek.flowers.domain.entities.Auth;
import com.micatek.flowers.domain.entities.User;
import com.micatek.flowers.infrastructures.repositories.AuthRepository;
import com.micatek.flowers.infrastructures.repositories.UserRepository;
import com.micatek.flowers.utils.Codes;
import com.micatek.flowers.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AuthService {
    private final AuthRepository authRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    /**
     * register authentication
     */

    @Transactional
    public RegistrationResponse register(RegistrationRequest request) {
        Auth existsAuth = authRepository.findByEmail(request.getEmail());
        if (existsAuth != null) {
            throw new AuthExistsException();
        }

        User user = new User();
        user.setRole(request.getRole());
        user.setEmail(request.getEmail());
        user.setFirstName(request.getName());
        user.setLastName(request.getName());
        user = userRepository.save(user);

        Auth auth = new Auth();
        auth.setEmail(request.getEmail());
        auth.setPassword(passwordEncoder.encode(request.getPassword()));
        auth.setUser(user);
        authRepository.save(auth);

        // response api
        RegistrationResponse response = new RegistrationResponse();
        response.setCode(Codes.SUCCESS);
        response.setResult(Constants.OK);
        return response;
    }

    public AuthResponse login(String email, String password) throws Exception {
        Auth auth = authRepository.findByEmail(email);

        if (auth == null) { throw new AuthNotFoundException(); }

        if (!passwordEncoder.matches(password, auth.getPassword())) {
            throw new UserNotFoundException();
        }

        String accessToken = jwtService.generateAccessToken(auth);
        String refreshToken = jwtService.generateRefreshToken(auth);

        AuthResponse response = new AuthResponse();
        response.setCode(Codes.SUCCESS);
        response.setResult(Constants.OK);
        response.setAccessToken(accessToken);
        response.setRefreshToken(refreshToken);
        response.setUser(auth.getUser());

        return response;
    }
}
