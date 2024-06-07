package com.micatek.flowers.application.services;

import com.micatek.flowers.domain.entities.User;
import com.micatek.flowers.infrastructures.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {
    private final UserRepository userRepository;

    public List<User> getEmployees() {
        return userRepository.getEmployees();
    }
}
