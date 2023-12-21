package com.avagyan.inventoryapp.dao;

import com.avagyan.inventoryapp.dto.Consignment;
import com.avagyan.inventoryapp.dto.ConsignmentDTO;
import com.avagyan.inventoryapp.dto.Dish;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Репозиторий для работы с накладной
 *
 * @author Abaev Evgeniy
 */
@Repository
public class ConsignmentRepository {
    private JdbcTemplate jdbcTemplate;

    public ConsignmentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Получение списка приходных накладных
     * @return список накладных
     */
    public List<ConsignmentDTO> getConsignmentList() {
        return jdbcTemplate.query(
                "select consignment.id       as id,\n" +
                        "       consignment.article  as article,\n" +
                        "       p.name               as productName,\n" +
                        "       quantity,\n" +
                        "       price,\n" +
                        "       quantity * consignment.price as totalPrice,\n" +
                        "       prv.id               as providerId,\n" +
                        "       prv.organizationName as organizationName,\n" +
                        "       prv.responsible      as responsible,\n" +
                        "       comeInDate,\n" +
                        "       expirationDate\n" +
                        "from consignment\n" +
                        "         join inventory_db.product p on consignment.article = p.article\n" +
                        "         join provider prv on consignment.providerId = prv.id\n" +
                        "where consignment.code = 'IN'\n" +
                        "order by id desc",
                BeanPropertyRowMapper.newInstance(ConsignmentDTO.class)
        );
    }

    /**
     * Получение списка уходных накладных
     * @return список накладных
     */
    public List<ConsignmentDTO> getCancellationList() {
        return jdbcTemplate.query(
                "select consignment.id      as id,\n" +
                        "       consignment.article as article,\n" +
                        "       p.name              as productName,\n" +
                        "       quantity,\n" +
                        "\n" +
                        "       comeInDate\n" +
                        "\n" +
                        "from consignment\n" +
                        "         join inventory_db.product p on consignment.article = p.article\n" +
                        "\n" +
                        "where consignment.code = 'OUT'\n" +
                        "order by id desc",
                BeanPropertyRowMapper.newInstance(ConsignmentDTO.class)
        );
    }

    /**
     * Создание приходной накладной
     * @param consignment приходная накладная
     */
    public void createConsignment(Consignment consignment) {
        jdbcTemplate.update(
                "INSERT INTO consignment (article, quantity, providerId, expirationDate, code) VALUES (?, ?, ?, ?, ?)",
                consignment.getArticle(),
                consignment.getQuantity(),
                consignment.getProviderId(),
                consignment.getDate(),
                "IN"
        );
    }

    /**
     * Создание уходной накладной
     * @param consignment уходная накладная
     */
    public void createCancellation(Consignment consignment) {
        jdbcTemplate.update(
                "INSERT INTO consignment (article, quantity, providerId, expirationDate, code) VALUES (?, ?, ?, ?, ?)",
                consignment.getArticle(),
                consignment.getQuantity(),
                consignment.getProviderId(),
                consignment.getDate(),
                "OUT"
        );
    }
}
