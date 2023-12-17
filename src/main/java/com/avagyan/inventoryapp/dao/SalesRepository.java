package com.avagyan.inventoryapp.dao;

import com.avagyan.inventoryapp.dto.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Abaev Evgeniy
 */

@Repository
@Transactional
public class SalesRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Sale> list() {
        return null;
    }

    public void save(Sale sale) {
    }

    public Sale get(int id) {
        return null;
    }

    public void update(Sale sale) {
    }

    public void delete(int id) {
    }
}
