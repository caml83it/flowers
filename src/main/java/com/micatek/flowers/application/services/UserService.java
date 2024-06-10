package com.micatek.flowers.application.services;

import com.micatek.flowers.domain.entities.User;
import com.micatek.flowers.domain.enums.UserRole;
import com.micatek.flowers.infrastructures.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {
    private final UserRepository userRepository;

    public Page<User> getEmployees(int page, int size) {
        return userRepository.findByRole(UserRole.EMPLOYEE, PageRequest.of(page, size));
    }

    public Page<User> getCustomers(int page, int size) {
        return userRepository.findByRole(UserRole.CUSTOMER, PageRequest.of(page, size));
    }
}
