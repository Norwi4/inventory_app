package com.avagyan.inventoryapp.dao;

import com.avagyan.inventoryapp.dto.RemainsDTO;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Abaev Evgeniy
 */
@Repository
public class RemainsRepository {
    private JdbcTemplate jdbcTemplate;

    public RemainsRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<RemainsDTO> getRemainsList() {
        return jdbcTemplate.query("select consignment.article,\n" +
                "       p.name                                                                         as productName,\n" +
                "       sum(IF(`code` = 'IN', `quantity`, 0)) - sum(IF(`code` = 'OUT', `quantity`, 0)) as quantity,\n" +
                "       w.name as warehouse_name\n" +
                "from consignment\n" +
                "         join product p on consignment.article = p.article\n" +
                "        join wharehouse w on p.warehouseId = w.id\n" +
                "\n" +
                "group by p.article order by warehouse_name", BeanPropertyRowMapper.newInstance(RemainsDTO.class));
    }
}
