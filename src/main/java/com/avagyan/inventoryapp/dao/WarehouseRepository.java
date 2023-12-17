package com.avagyan.inventoryapp.dao;

import com.avagyan.inventoryapp.dto.Warehouse;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Abaev Evgeniy
 */
@Repository
public class WarehouseRepository {
    private JdbcTemplate jdbcTemplate;

    public WarehouseRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Создание склада
     * @param warehouse информация о складе
     */
    public void createWarehouse(Warehouse warehouse) {
        jdbcTemplate.update("INSERT INTO wharehouse (name) VALUES (?)", warehouse.getName());
    }

    /**
     * Получение списка складов
     * @return список складов
     */
    public List<Warehouse> getWarehouseList() {
        return jdbcTemplate.query(
                "SELECT * FROM wharehouse",
                BeanPropertyRowMapper.newInstance(Warehouse.class)
        );
    }
}
