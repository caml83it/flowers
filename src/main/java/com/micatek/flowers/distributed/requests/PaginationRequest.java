package com.micatek.flowers.distributed.requests;


import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class PaginationRequest {
    @Min(value = 0, message = "Page number cannot be less than 0")
    private int page = 0;

    @Min(value = 1, message = "Page size must be at least 1")
    private int size = 30;
}
