package ru.galtor85.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import ru.galtor85.shop.entity.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Поиск пользователя по email
    Optional<User> findByEmail(String email);

    // Поиск пользователя по username
    Optional<User> findByUsername(String username);

    // Проверка существования пользователя по email
    boolean existsByEmail(String email);

    // Проверка существования пользователя по username
    boolean existsByUsername(String username);

    // Получение всех пользователей с ролью ROLE_ADMIN
    List<User> findByRole_Name(String roleName);
}
