package com.avagyan.inventoryapp.service;

import com.avagyan.inventoryapp.dao.ConsignmentRepository;
import com.avagyan.inventoryapp.dto.Consignment;
import com.avagyan.inventoryapp.dto.ConsignmentDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Abaev Evgeniy
 */
@Service
public class ConsignmentService {
    private ConsignmentRepository repository;

    public ConsignmentService(ConsignmentRepository repository) {
        this.repository = repository;
    }

    /**
     * Список приходных накладных
     * @return список накладных
     */
    public List<ConsignmentDTO> getConsignmentList() {
        return repository.getConsignmentList();
    }

    /**
     * Создание приходной накладной
     * @param consignment накладная
     */
    public void createConsignment(Consignment consignment) {
        repository.createConsignment(consignment);
    }

    /**
     * Получить список уходных накладных
     * @return список накладных
     */
    public List<ConsignmentDTO> getCancellationList() {
        return repository.getCancellationList();
    }

    /**
     * Создание уходной накладной
     * @param consignment накладная
     */
    public void createCancellation(Consignment consignment) {
        repository.createCancellation(consignment);
    }
}
