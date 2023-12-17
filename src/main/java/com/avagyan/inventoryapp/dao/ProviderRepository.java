package com.avagyan.inventoryapp.dao;

import com.avagyan.inventoryapp.dto.Consignment;
import com.avagyan.inventoryapp.dto.Provider;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Репозиторий для работы с поставщиками
 *
 * @author Abaev Evgeniy
 */
@Repository
public class ProviderRepository {
    private JdbcTemplate jdbcTemplate;

    public ProviderRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Получение списка поставщиков
     * @return список поставщиков
     */
    public List<Provider> getProviderList() {
        return jdbcTemplate.query(
                "SELECT * FROM provider",
                BeanPropertyRowMapper.newInstance(Provider.class)
        );
    }

    /**
     * Создание поставщика
     * @param consignment поставщик
     */
    public void createProvider(Consignment consignment) {
        jdbcTemplate.update(
                "INSERT INTO provider (organizationName, responsible) VALUES (?, ?)",
                consignment.getArticle(),
                consignment.getQuantity()
        );
    }
}
