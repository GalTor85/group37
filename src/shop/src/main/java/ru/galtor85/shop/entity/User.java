package ru.galtor85.shop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
