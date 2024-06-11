package com.micatek.flowers.domain.entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.micatek.flowers.domain.listeners.ProductListener;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "products", indexes = @Index(columnList = "name", name = "idx_product_name"))
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EntityListeners(ProductListener.class)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private Long price;

    @JsonProperty("created_at")
    @Column(nullable = false, name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @JsonProperty("updated_at")
    @Column(nullable = false, name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<OrderProductItem> orderProductItems;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
