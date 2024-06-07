package com.micatek.flowers.application.services;

import com.micatek.flowers.application.codes.ErrorMessages;
import com.micatek.flowers.domain.entities.Auth;
import com.micatek.flowers.infrastructures.repositories.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserDetailsServiceImpl implements UserDetailsService {
    private final AuthRepository authRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Auth auth = authRepository.findByEmail(username);
        if (auth == null) {
            throw new UsernameNotFoundException(ErrorMessages.AUTH_NOT_FOUND.getMessage());
        }
        return auth;
    }
}
