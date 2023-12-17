package com.avagyan.inventoryapp.dao;

import com.avagyan.inventoryapp.dto.Product;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Abaev Evgeniy
 */
@Repository
public class ProductRepository {
    private JdbcTemplate jdbcTemplate;

    public ProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Получить список товаров
     * @return список товаров
     */
    public List<Product> products() {
        return jdbcTemplate.query(
                "select * from product",
                BeanPropertyRowMapper.newInstance(Product.class)
        );
    }


}
