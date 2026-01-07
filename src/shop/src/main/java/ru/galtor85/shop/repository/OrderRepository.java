package ru.galtor85.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.galtor85.shop.entity.Order;
import ru.galtor85.shop.entity.User;

import java.util.List;
import java.util.Optional;
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    // Получение заказов пользователя
    List<Order> findByUser(User user);

    // Получение заказов по статусу
    List<Order> findByStatus(String status);

    // Подсчёт заказов пользователя
    Long countByUser(User user);

    // Получение последнего заказа пользователя
    Optional<Order> findTopByUserOrderByIdDesc(User user);
}