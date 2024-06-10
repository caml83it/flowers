package com.micatek.flowers.distributed.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.micatek.flowers.application.redis.RedisProductService;
import com.micatek.flowers.application.services.ProductService;
import com.micatek.flowers.distributed.requests.PaginationRequest;
import com.micatek.flowers.distributed.responses.PaginationResponse;
import com.micatek.flowers.domain.entities.Product;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(name = "/products")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductController {
    private final ProductService productService;
    private final RedisProductService redisProductService;

    @GetMapping
    public ResponseEntity<PaginationResponse<Product>> getProducts(@Valid @ModelAttribute PaginationRequest request) throws JsonProcessingException {
        Page<Product> paginateUserList;

        paginateUserList = redisProductService.getAllProducts(request.getPage(), request.getSize());
        if (paginateUserList == null) {
            paginateUserList = productService.getProducts(request.getPage(), request.getSize());
            redisProductService.saveAllProducts(paginateUserList, paginateUserList.getNumber(), paginateUserList.getSize());
        }

        PaginationResponse<Product> response = new PaginationResponse<>(
            paginateUserList.getContent(),
            paginateUserList.getTotalElements(),
            paginateUserList.getTotalPages(),
            paginateUserList.getNumber(),
            paginateUserList.getSize()
        );
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) throws JsonProcessingException {
        Product resultProduct;
        resultProduct = redisProductService.getProduct(id);

        if (resultProduct == null) {
            resultProduct = productService.getProduct(id);
            redisProductService.saveProduct(resultProduct, id);
        }

        return ResponseEntity.ok(resultProduct);
    }
}
