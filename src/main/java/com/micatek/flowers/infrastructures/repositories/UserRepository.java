package com.micatek.flowers.infrastructures.repositories;

import com.micatek.flowers.domain.entities.User;
import com.micatek.flowers.domain.enums.UserRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT e FROM User e WHERE e.role='EMPLOYEE'")
    public List<User> getEmployees();

    Page<User> findByRole(UserRole role, Pageable pageable);
}
