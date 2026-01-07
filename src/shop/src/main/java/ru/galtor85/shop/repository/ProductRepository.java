package ru.galtor85.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.galtor85.shop.entity.Category;
import ru.galtor85.shop.entity.Product;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // Поиск товара по названию (частичное совпадение)
    List<Product> findByNameContaining(String name);

    // Поиск товара по категории
    List<Product> findByCategory(Category category);

    // Поиск товара по цене (диапазон)
    List<Product> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);

    // Проверка наличия товара по ID
    boolean existsById(Long id);

    // Подсчёт товаров в категории
    Long countByCategory(Category category);
}
