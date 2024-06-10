package com.micatek.flowers.infrastructures.repositories;

import com.micatek.flowers.domain.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
