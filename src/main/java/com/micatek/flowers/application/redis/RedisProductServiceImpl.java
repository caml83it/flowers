package com.micatek.flowers.application.redis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.micatek.flowers.domain.entities.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RedisProductServiceImpl implements RedisProductService {
    private final RedisTemplate<String, Object> redisTemplate;
    private final ObjectMapper objectMapper;


    @Override
    public void clear() {
        Set<String> productRedisKeys = redisTemplate.keys("*");
        if (productRedisKeys == null) {
            return;
        }
        for (String key : productRedisKeys) {
            redisTemplate.delete(key);
        }
    }

    @Override
    public Page<Product> getAllProducts(int page, int size) throws JsonProcessingException {
        String redisKey = generatePaginationRedisKey(PageRequest.of(page, size));
        String jsonString = (String) redisTemplate.opsForValue().get(redisKey);
        if (jsonString == null) return null;
        return objectMapper.readValue(jsonString, new TypeReference<Page<Product>>() {
        });
    }

    @Override
    public void saveAllProducts(Page<Product> response, int page, int size) throws JsonProcessingException {
        String redisKey = generatePaginationRedisKey(PageRequest.of(page, size));
        String jsonString = objectMapper.writeValueAsString(response);
        redisTemplate.opsForValue().set(redisKey, jsonString);
    }

    private String generatePaginationRedisKey(PageRequest request) {
        int pageNumber = request.getPageNumber();
        int pageSize = request.getPageSize();
        return String.format("%s_%s:::%s_%d:::%s_%d", RedisConstants.PRODUCTS, RedisConstants.ALL, RedisConstants.PAGE, pageNumber, RedisConstants.SIZE, pageSize);
    }

    private String generateItemRedisKey(Long id) {
        return String.format("%s_%s:::%s_%d", RedisConstants.PRODUCTS, RedisConstants.ITEM, RedisConstants.ID, id);
    }
}
