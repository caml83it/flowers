package com.micatek.flowers.infrastructures.repositories;

import com.micatek.flowers.domain.entities.Auth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<Auth, Long> {
    @Query("SELECT u FROM Auth u WHERE u.email=?1")
    Auth findByEmail(String email);
}
