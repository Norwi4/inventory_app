package com.avagyan.inventoryapp.dao;

import com.avagyan.inventoryapp.dto.*;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Репозиторий для работы с блюдами
 *
 * @author Abaev Evgeniy
 */
@Repository
public class DishRepository {
    private JdbcTemplate jdbcTemplate;

    public DishRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Получить список блюд
     * @return список блюд
     */
    public List<DishDTO> getDishList() {
        return jdbcTemplate.query("select * from dish", BeanPropertyRowMapper.newInstance(DishDTO.class));
    }

    /**
     * Создать блюдо
     */
    public void createDish(Dish dish) {
        jdbcTemplate.update(
                "insert into dish (name) values (?)",
                dish.getName()
        );
    }


    /**
     * Добавить ингредиенты к блюду
     */
    public void addProduct(Dish dish, Long dishId) {
        for (Long article : dish.getProductDTO()) {
            ProductDTO product = jdbcTemplate.queryForObject(
                    "select id, article, name from product where article=?",
                    BeanPropertyRowMapper.newInstance(ProductDTO.class),
                    article
            );
            jdbcTemplate.update("insert into dish_product (article, dish_id) values (?, ?)",
                    product.getArticle(),
                    dishId
            );
        }
    }

    /**
     * Получение списка ингредиентов блюда
     * @param dishId
     * @return
     */
    public List<ProductsDishDTO> getDishProducts(Long dishId) {
        return jdbcTemplate.query(
                "select dish_product.id, dish_product.article, p.name from dish_product\n" +
                "join product p on dish_product.article = p.article\n" +
                "join dish d on dish_product.dish_id = d.id where dish_id = ?",
                BeanPropertyRowMapper.newInstance(ProductsDishDTO.class),
                dishId);
    }

    /**
     * Обновление кол-ва инггредиентов блюда
     * @param productDTO
     */
    public void saveQuantityProducts(List<ProductDTO> productDTO) {
        for (Optional<Integer> quantity : productDTO.stream().map(ProductDTO::getQuantity).toList()) {
            jdbcTemplate.update("insert into dish_product(quantity) values (?)", quantity);
        }
    }

    public Long getLastId() {
        return jdbcTemplate.queryForObject(
                "select id from dish order by id desc limit 1",
                Long.class);
    }
}
