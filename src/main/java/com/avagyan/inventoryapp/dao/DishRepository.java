package com.avagyan.inventoryapp.dao;

import com.avagyan.inventoryapp.dto.*;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Репозиторий для работы с блюдами
 *
 * @author Abaev Evgeniy
 */
@Repository
public class DishRepository {
    private JdbcTemplate jdbcTemplate;
    private ConsignmentRepository consignmentRepository;

    public DishRepository(JdbcTemplate jdbcTemplate, ConsignmentRepository consignmentRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.consignmentRepository = consignmentRepository;
    }

    /**
     * Получить список блюд
     * @return список блюд
     */
    public List<DishDTO> getDishList() {
        return jdbcTemplate.query("select * from dish", BeanPropertyRowMapper.newInstance(DishDTO.class));
    }

    /**
     * Получить блюдо по идентификатору
     * @param id
     * @return
     */
    public DishDTO getDishById(Long id) {
        return jdbcTemplate.queryForObject("select id, name from dish where id=?",
                BeanPropertyRowMapper.newInstance(DishDTO.class),
                id);
    }

    /**
     * Получить ингредиенты по id блюда
     * @param id
     * @return
     */
    public List<ProductDTO> products(Long id) {
        return jdbcTemplate.query("select dish_product.article, name, quantity, dish_product.dish_id\n" +
                "from dish_product\n" +
                "         left join inventory_db.product p on dish_product.article = p.article\n" +
                "where dish_id=?", BeanPropertyRowMapper.newInstance(ProductDTO.class), id);
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
    public List<ProductDTO> getDishProducts(Long dishId) {
        return jdbcTemplate.query(
                "select dish_product.id, dish_product.article, p.name from dish_product\n" +
                "join product p on dish_product.article = p.article\n" +
                "join dish d on dish_product.dish_id = d.id where dish_id = ?",
                BeanPropertyRowMapper.newInstance(ProductDTO.class),
                dishId);
    }

    /**
     * Обновление кол-ва инггредиентов блюда
     * @param productDTO
     */
    public void saveQuantityProducts(List<ProductDTO> productDTO) {
        for (ProductDTO product : productDTO) {
            jdbcTemplate.update("insert into dish_product(quantity) values (?) where article=?", product.getQuantity(), product.getArticle());
        }
    }

    /**
     * Списание блюда
     */
    public void consignmentDish(CancellationDish cancellationDish) {
        List<ProductDTO> productDTO = jdbcTemplate.query("select p.id                 as id,\n" +
                "       dish_product.article as article,\n" +
                "       p.name               as name,\n" +
                "       quantity             as quantity,\n" +
                "       dish_product.dish_id\n" +
                "\n" +
                "from dish_product\n" +
                "         join inventory_db.product p on dish_product.article = p.article\n" +
                "where dish_id =?", BeanPropertyRowMapper.newInstance(ProductDTO.class), cancellationDish.getDishId());

        for (ProductDTO dto : productDTO){
            var count = dto.getQuantity().get() * cancellationDish.getCount();
            consignmentRepository.createCancellation(new Consignment(dto.getArticle(), count));
        }
    }

    public Long getLastId() {
        return jdbcTemplate.queryForObject(
                "select id from dish order by id desc limit 1",
                Long.class);
    }
}
