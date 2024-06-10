package com.micatek.flowers.distributed.controllers;

import com.micatek.flowers.application.services.ProductService;
import com.micatek.flowers.distributed.requests.PaginationRequest;
import com.micatek.flowers.distributed.responses.PaginationResponse;
import com.micatek.flowers.domain.entities.Product;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/products")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<PaginationResponse<Product>> getProducts(@Valid @ModelAttribute PaginationRequest request) {
        Page<Product> paginateUserList = productService.getProducts(request.getPage(), request.getSize());
        PaginationResponse<Product> response = new PaginationResponse<>(
            paginateUserList.getContent(),
            paginateUserList.getTotalElements(),
            paginateUserList.getTotalPages(),
            paginateUserList.getNumber(),
            paginateUserList.getSize()
        );
        return ResponseEntity.ok(response);
    }
}
