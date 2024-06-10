package com.micatek.flowers.distributed.controllers;

import com.micatek.flowers.application.services.UserService;
import com.micatek.flowers.common.annotations.IsAdmin;
import com.micatek.flowers.distributed.requests.PaginationRequest;
import com.micatek.flowers.distributed.responses.PaginationResponse;
import com.micatek.flowers.domain.entities.User;
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
@RequestMapping("/customers")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CustomerController {
    private final UserService userService;

    @IsAdmin
    @GetMapping
    public ResponseEntity<PaginationResponse<User>> getCustomers(@Valid @ModelAttribute PaginationRequest request) {
        Page<User> paginateUserList = userService.getCustomers(request.getPage(), request.getSize());
        PaginationResponse<User> response = new PaginationResponse<>(
            paginateUserList.getContent(),
            paginateUserList.getTotalElements(),
            paginateUserList.getTotalPages(),
            paginateUserList.getNumber(),
            paginateUserList.getSize()
        );
        return ResponseEntity.ok(response);
    }
}
