package ru.galtor85.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.galtor85.shop.entity.Order;
import ru.galtor85.shop.entity.OrderItem;
import ru.galtor85.shop.entity.Product;

import java.util.List;
@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    // Получение позиций заказа по заказу
    List<OrderItem> findByOrder(Order order);

    // Получение позиций по товару
    List<OrderItem> findByProduct(Product product);

    // Подсчёт позиций в заказе
    Long countByOrder(Order order);

    // Суммирование количества товара в заказах
    @Query("SELECT SUM(oi.quantity) FROM OrderItem oi WHERE oi.product = ?1")
    Integer sumQuantityByProduct(Product product);
}
