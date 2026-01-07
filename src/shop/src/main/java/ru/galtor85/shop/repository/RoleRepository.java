package ru.galtor85.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.galtor85.shop.entity.Role;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    // Поиск роли по имени
    Optional<Role> findByName(String name);

    // Проверка существования роли
    boolean existsByName(String name);
}