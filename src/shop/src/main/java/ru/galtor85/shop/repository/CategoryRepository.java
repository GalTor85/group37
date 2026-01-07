package ru.galtor85.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.galtor85.shop.entity.Category;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    // Поиск категории по имени
    Optional<Category> findByName(String name);

    // Проверка существования категории по имени
    boolean existsByName(String name);

    // Подсчёт категорий
    long count();

    // Получение всех категорий с товарами (исключая пустые)
    List<Category> findByProductsIsNotNull();
}
