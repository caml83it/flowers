package com.micatek.flowers.application.services;

import com.micatek.flowers.infrastructures.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrderService {
    private final OrderRepository orderRepository;
}
