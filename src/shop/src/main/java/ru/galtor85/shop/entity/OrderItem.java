package ru.galtor85.shop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

@Entity
@Table(name = "order_items")
@Getter
@Setter

public class OrderItem {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private Integer quantity;
    private BigDecimal unitPrice;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
