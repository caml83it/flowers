package com.micatek.flowers.application.redis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.micatek.flowers.domain.entities.Product;
import org.springframework.data.domain.Page;

public interface RedisProductService {
    // clear all cache
    void clear();

    Page<Product> getAllProducts(int page, int size) throws JsonProcessingException;
    Product getProduct(Long id) throws JsonProcessingException;

    void saveAllProducts(Page<Product> response, int page, int size) throws JsonProcessingException;
    void saveProduct(Product response, Long id) throws JsonProcessingException;
}
