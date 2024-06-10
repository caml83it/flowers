package com.micatek.flowers.domain.listeners;

import com.micatek.flowers.application.redis.RedisProductService;
import com.micatek.flowers.domain.entities.Product;
import jakarta.persistence.PostPersist;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;


@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProductListener {
    private final RedisProductService redisProductService;

    @PostPersist
    public void postPersist(Product product) {
        redisProductService.clear();
    }
}
