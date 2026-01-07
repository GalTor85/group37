package ru.galtor85.shop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Getter
@Setter
public class Product {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private BigDecimal price;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    private Integer stockQuantity;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
