package com.micatek.flowers.infrastructures.repositories;

import com.micatek.flowers.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT e FROM User e WHERE e.role='EMPLOYEE'")
    public List<User> getEmployees();
}
